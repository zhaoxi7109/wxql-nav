package com.zhaoxi.admin.system.menu.enums;

/**
 * 菜单类型
 *
 * @author zhaoxi
 */
public enum MenuType {
    /**
     * 目录
     */
    DIRECTORY("D"),

    /**
     * 菜单
     */
    MENU("M"),

    /**
     * 按钮
     */
    BUTTON("B")
    ;

    public final String code;

    MenuType(String code) {
        this.code = code;
    }
}
