package com.zhaoxi.admin.nav.config.mapper;

import com.zhaoxi.admin.nav.config.po.NavSiteConfig;
import com.zhaoxi.common.framework.web.mapper.BaseMapperPlus;
import org.apache.ibatis.annotations.Mapper;

/**
 * 网站配置
 *
 * @author zhaoxi
 */
@Mapper
public interface NavSiteConfigMapper extends BaseMapperPlus<NavSiteConfig> {

    /**
     * 更新访问量
     */
    void updateVisitCount(Long id);
}