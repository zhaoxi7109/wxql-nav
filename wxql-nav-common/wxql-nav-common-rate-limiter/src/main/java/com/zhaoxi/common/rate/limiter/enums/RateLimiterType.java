package com.zhaoxi.common.rate.limiter.enums;

/**
 * 限流类型
 *
 * @author zhaoxi
 */
public enum RateLimiterType {

    /**
     * 默认策略全局限流
     */
    DEFAULT,

    /**
     * 根据请求 IP 进行限流
     */
    IP,

    /**
     * 根据用户限流
     */
    USER

}
