package com.zhaoxi.admin.system.menu.enums;

/**
 * 菜单状态
 *
 * @author zhaoxi
 */
public enum MenuStatus {

    /**
     * 正常
     */
    NORMAL(1),

    /**
     * 停用
     */
    DISABLE(2)
    ;

    public final Integer code;

    MenuStatus(Integer code) {
        this.code = code;
    }
}
