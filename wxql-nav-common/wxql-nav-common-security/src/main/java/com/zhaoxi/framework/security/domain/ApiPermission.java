package com.zhaoxi.framework.security.domain;

import lombok.Data;

/**
 * 接口权限
 *
 * @author zhaoxi
 */
@Data
public class ApiPermission {

    /**
     * 接口地址
     */
    private String apiUrl;

    /**
     * 接口请求方式
     */
    private String apiMethod;

}
