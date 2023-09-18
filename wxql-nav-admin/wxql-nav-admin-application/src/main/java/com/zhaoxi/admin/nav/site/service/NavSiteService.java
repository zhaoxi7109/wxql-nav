package com.zhaoxi.admin.nav.site.service;

import com.zhaoxi.admin.client.search.vo.NavClientSiteSearchVO;
import com.zhaoxi.admin.nav.site.dto.NavSitePageDTO;
import com.zhaoxi.admin.nav.site.dto.NavSiteUpdateDTO;
import com.zhaoxi.admin.nav.site.po.NavSite;
import com.zhaoxi.admin.nav.site.vo.NavSiteVO;
import com.zhaoxi.common.framework.mybatis.page.vo.PageVO;
import com.zhaoxi.common.framework.web.service.BaseService;
import com.zhaoxi.admin.nav.site.dto.NavSiteAddDTO;

import java.util.List;

/**
 * 导航网站
 *
 * @author zhaoxi
 */
public interface NavSiteService extends BaseService<NavSite> {

    /**
     * 分页列表
     */
    PageVO<NavSiteVO> pageList(NavSitePageDTO pageDTO);

    /**
     * 新增
     */
    void save(NavSiteAddDTO addDTO);

    /**
     * 修改
     */
    void updateById(NavSiteUpdateDTO updateDTO);

    /**
     * 删除
     */
    void removeByIds(Long[] ids);

    /**
     * 获取最大排序
     */
    Integer getMaxSortByCategoryId(Long categoryId);

    /**
     * 更新点击量
     */
    void updateClickCountById(Long id);


    /**
     * 站內网站搜索
     */
    List<NavClientSiteSearchVO> siteSearch(String searchContent);

}
