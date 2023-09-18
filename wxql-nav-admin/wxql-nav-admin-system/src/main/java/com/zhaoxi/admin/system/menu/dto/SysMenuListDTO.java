package com.zhaoxi.admin.system.menu.dto;

import com.zhaoxi.common.framework.mybatis.plugin.annotation.Query;
import com.zhaoxi.common.framework.mybatis.plugin.enums.QueryWay;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 查询菜单
 *
 * @author zhaoxi
 */
@Data
@ApiModel("查询菜单")
public class SysMenuListDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("菜单名称")
    @Query(QueryWay.LIKE)
    private String menuName;

    @ApiModelProperty("菜单状态")
    private Integer status;

    @ApiModelProperty(value = "排序列，多个用逗号分开", hidden = true)
    @Query(ignore = true)
    private String orderColumn;

    @ApiModelProperty(value = "排序类型(asc 或 desc)，多个用逗号分开", hidden = true)
    @Query(ignore = true)
    private String orderType;

}
