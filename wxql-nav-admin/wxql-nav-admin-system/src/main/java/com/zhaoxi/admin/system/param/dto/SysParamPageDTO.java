package com.zhaoxi.admin.system.param.dto;

import com.zhaoxi.common.framework.mybatis.page.dto.PageDTO;
import com.zhaoxi.common.framework.mybatis.plugin.annotation.Query;
import com.zhaoxi.common.framework.mybatis.plugin.enums.QueryWay;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 参数配置分页
 *
 * @author zhaoxi
 * @date 2022/8/16
 */
@Data
@ApiModel("参数配置分页")
public class SysParamPageDTO extends PageDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("参数名称")
    @Query(QueryWay.LIKE)
    private String paramName;

    @ApiModelProperty("参数键")
    @Query(QueryWay.LIKE)
    private String paramKey;

    @ApiModelProperty("参数值")
    @Query(QueryWay.LIKE)
    private String paramValue;

}
