package com.zhaoxi.admin.client.nav.service;

import com.zhaoxi.admin.client.nav.vo.NavCategoryClientVO;
import com.zhaoxi.admin.client.nav.vo.NavClientListVO;

import java.util.List;

/**
 * 导航客户端
 *
 * @author zhaoxi
 */
public interface ClientNavService {

    /**
     * 分类网站列表
     */
    NavClientListVO categorySiteList();

    /**
     * 分类列表
     */
    List<NavCategoryClientVO> categoryList();

    /**
     * 清除缓存
     */
    void removeCache();

    /**
     * 站内分类网站搜索列表
     */
    NavClientListVO categorySiteSearchList(String searchContent);
}
