package com.zhaoxi.common.core.enums;

/**
 * 是否枚举
 *
 * @author zhaoxi
 */
public enum YesNo {

    /**
     * 是
     */
    YES(1),

    /**
     * 否
     */
    NO(2)
    ;

    public final Integer code;

    YesNo(Integer code) {
        this.code = code;
    }
}
