package com.zhaoxi.admin.nav.index.service;

import com.zhaoxi.admin.nav.index.vo.NavIndexStatisticsVO;

/**
 * 后台首页
 *
 * @author zhaoxi
 */
public interface NavIndexService {

    /**
     * 获取统计数
     */
    NavIndexStatisticsVO getStatistics();
}
