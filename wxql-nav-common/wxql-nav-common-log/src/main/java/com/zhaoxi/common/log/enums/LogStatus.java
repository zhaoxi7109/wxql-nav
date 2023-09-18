package com.zhaoxi.common.log.enums;

/**
 * 日志状态
 *
 * @author zhaoxi
 * @date 2022/7/5
 */
public enum LogStatus {
    /**
     * 成功
     */
    SUCCESS(1),

    /**
     * 失败
     */
    ERROR(2)
    ;

    public final Integer code;

    LogStatus(Integer code) {
        this.code = code;
    }
}
