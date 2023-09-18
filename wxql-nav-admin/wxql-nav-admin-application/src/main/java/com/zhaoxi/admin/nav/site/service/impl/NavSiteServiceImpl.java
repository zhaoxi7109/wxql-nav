package com.zhaoxi.admin.nav.site.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.zhaoxi.admin.client.nav.service.ClientNavService;
import com.zhaoxi.admin.client.search.vo.NavClientSiteSearchVO;
import com.zhaoxi.admin.nav.category.mapper.NavCategoryMapper;
import com.zhaoxi.admin.nav.category.po.NavCategory;
import com.zhaoxi.admin.nav.site.dto.NavSiteAddDTO;
import com.zhaoxi.admin.nav.site.dto.NavSitePageDTO;
import com.zhaoxi.admin.nav.site.dto.NavSiteUpdateDTO;
import com.zhaoxi.admin.nav.site.mapper.NavSiteMapper;
import com.zhaoxi.admin.nav.site.mapstrcut.NavSiteConverter;
import com.zhaoxi.admin.nav.site.po.NavSite;
import com.zhaoxi.admin.nav.site.service.NavSiteService;
import com.zhaoxi.admin.nav.site.vo.NavSiteVO;
import com.zhaoxi.common.core.enums.CommonStatus;
import com.zhaoxi.common.core.util.string.StrUtils;
import com.zhaoxi.common.framework.manager.AsyncManager;
import com.zhaoxi.common.framework.mybatis.page.vo.PageVO;
import com.zhaoxi.common.framework.mybatis.plugin.query.QueryWrapperPlus;
import com.zhaoxi.common.framework.web.service.impl.BaseServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 导航网站
 *
 * @author zhaoxi
 */
@Service
public class NavSiteServiceImpl extends BaseServiceImpl<NavSiteMapper, NavSite> implements NavSiteService {

    private final Logger log = LoggerFactory.getLogger(NavSiteServiceImpl.class);

    @Autowired
    private NavSiteMapper navSiteMapper;
    @Autowired
    private NavCategoryMapper navCategoryMapper;
    @Autowired
    private ClientNavService clientNavService;

    /**
     * 分页列表
     */
    @Override
    public PageVO<NavSiteVO> pageList(NavSitePageDTO pageDTO) {
        QueryWrapperPlus<NavSite> wrapper = buildQueryWrapper(pageDTO);
        if (StrUtils.isNotBlank(pageDTO.getSiteNameDescription())) {
            wrapper.lambda().and(w -> {
                w.like(NavSite::getSiteName, pageDTO.getSiteNameDescription())
                        .or()
                        .like(NavSite::getSiteDescription, pageDTO.getSiteNameDescription());
            });
        }
        PageVO<NavSiteVO> pageVO = NavSiteConverter.INSTANCE.convert(navSiteMapper.selectPage(pageDTO, wrapper));
        // 获取对应的分类名称
        buildCategoryName(pageVO.getList());
        return pageVO;
    }

    /**
     * 新增
     */
    @Override
    public void save(NavSiteAddDTO addDTO) {
        NavSite navSite = NavSiteConverter.INSTANCE.convert(addDTO);
        navSiteMapper.insert(navSite);
        // 清除缓存，等后续访问时会自动从数据库获取
        AsyncManager.me().execute(() -> clientNavService.removeCache());
    }

    /**
     * 修改
     */
    @Override
    public void updateById(NavSiteUpdateDTO updateDTO) {
        NavSite navSite = NavSiteConverter.INSTANCE.convert(updateDTO);
        navSiteMapper.updateById(navSite);
        // 清除缓存，等后续访问时会自动从数据库获取
        AsyncManager.me().execute(() -> clientNavService.removeCache());
    }

    /**
     * 删除
     */
    @Override
    public void removeByIds(Long[] ids) {
        super.removeByIds(Arrays.asList(ids));
        // 清除缓存，等后续访问时会自动从数据库获取
        AsyncManager.me().execute(() -> clientNavService.removeCache());
    }

    /**
     * 获取最大排序
     */
    @Override
    public Integer getMaxSortByCategoryId(Long categoryId) {
        return navSiteMapper.selectMaxSortByCategoryId(categoryId);
    }

    /**
     * 更新点击量
     */
    @Override
    public void updateClickCountById(Long id) {
        navSiteMapper.updateClickCountById(id);
    }

    /**
     * 站內网站搜索
     */
    @Override
    public List<NavClientSiteSearchVO> siteSearch(String searchContent) {
        if (StringUtils.isBlank(searchContent)) {
            return new ArrayList<>();
        }
        return navSiteMapper.selectSiteSearchList(searchContent, CommonStatus.NORMAL.code);
    }

    /**
     * 构造分类名称
     */
    private void buildCategoryName(List<NavSiteVO> list) {
        if (CollectionUtils.isEmpty(list)) {
            return;
        }
        Set<Long> categoryIds = list.parallelStream().map(s -> s.getCategoryId()).collect(Collectors.toSet());
        LambdaQueryWrapper<NavCategory> categoryWrapper = new LambdaQueryWrapper<>();
        categoryWrapper.in(NavCategory::getId, categoryIds);
        categoryWrapper.select(NavCategory::getId, NavCategory::getCategoryName);
        List<NavCategory> categoryList = navCategoryMapper.selectList(categoryWrapper);
        list.forEach(site -> {
            NavCategory category = categoryList.parallelStream().filter(c -> c.getId().equals(site.getCategoryId()))
                    .findFirst().orElse(null);
            if (category != null) {
                site.setCategoryName(category.getCategoryName());
            }
        });
    }

}
