package com.zhaoxi.framework.security.property;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 权限配置
 *
 * @author zhaoxi
 * @date 2022/3/20
 */
@ConfigurationProperties(prefix = "security")
@Component
@Data
public class SecurityProperty {

    /**
     * 不用登录就能访问的地址
     */
    private String[] notLoginUrls;

}
