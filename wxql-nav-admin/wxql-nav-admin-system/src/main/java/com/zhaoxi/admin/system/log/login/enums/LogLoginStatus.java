package com.zhaoxi.admin.system.log.login.enums;

/**
 * 登录日志状态
 *
 * @author zhaoxi
 * @date 2022/7/3
 */
public enum LogLoginStatus {

    /**
     * 成功
     */
    SUCCESS(1),

    /**
     * 失败
     */
    FAIL(2)
    ;

    public final Integer code;


    LogLoginStatus(Integer code) {
        this.code = code;
    }
}
