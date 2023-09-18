package com.zhaoxi.admin.nav.index.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.zhaoxi.admin.nav.category.mapper.NavCategoryMapper;
import com.zhaoxi.admin.nav.index.service.NavIndexService;
import com.zhaoxi.admin.nav.index.vo.NavIndexStatisticsVO;
import com.zhaoxi.admin.nav.site.mapper.NavSiteMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 后台首页
 *
 * @author zhaoxi
 */
@Service
public class NavIndexServiceImpl implements NavIndexService {

    @Autowired
    private NavCategoryMapper navCategoryMapper;
    @Autowired
    private NavSiteMapper navSiteMapper;

    /**
     * 获取统计数
     */
    @Override
    public NavIndexStatisticsVO getStatistics() {
        NavIndexStatisticsVO statisticsVO = new NavIndexStatisticsVO();

        // 获取分类数
        statisticsVO.setCategoryCount(navCategoryMapper.selectCount(new LambdaQueryWrapper<>()));
        // 获取网站数
        statisticsVO.setSiteCount(navSiteMapper.selectCount(new LambdaQueryWrapper<>()));
        // 获取网站点击量信息
        statisticsVO.setSiteClickCount(navSiteMapper.selectClickCount());

        return statisticsVO;
    }
}
