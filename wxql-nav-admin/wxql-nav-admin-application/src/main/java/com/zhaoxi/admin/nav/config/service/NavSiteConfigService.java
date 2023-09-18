package com.zhaoxi.admin.nav.config.service;

import com.zhaoxi.admin.nav.config.dto.NavSiteConfigUpdateDTO;
import com.zhaoxi.admin.nav.config.po.NavSiteConfig;
import com.zhaoxi.admin.nav.config.vo.NavSiteConfigAboutVO;
import com.zhaoxi.admin.nav.config.vo.NavSiteConfigVO;
import com.zhaoxi.common.framework.web.service.BaseService;

/**
 * 网站配置
 *
 * @author zhaoxi
 */
public interface NavSiteConfigService extends BaseService<NavSiteConfig> {


    /**
     * 获取配置
     */
    NavSiteConfigVO getConfig();

    /**
     * 更新
     */
    void updateById(NavSiteConfigUpdateDTO updateDTO);


    /**
     * 关于本站
     */
    NavSiteConfigAboutVO about();

}
