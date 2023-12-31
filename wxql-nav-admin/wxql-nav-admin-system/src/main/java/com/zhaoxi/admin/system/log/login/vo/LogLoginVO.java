package com.zhaoxi.admin.system.log.login.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 登录日志
 *
 * @author zhaoxi
 * @date 2022/7/3
 */
@Data
public class LogLoginVO implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("登录日志 id")
    private Long id;

    @ApiModelProperty("登录用户名")
    private String username;

    @ApiModelProperty("登录 ip 地址")
    private String ipAddress;

    @ApiModelProperty("登录位置")
    private String loginLocation;

    @ApiModelProperty("浏览器类型")
    private String browserType;

    @ApiModelProperty("操作系统")
    private String operateSystem;

    @ApiModelProperty("登录状态（1 成功，2 失败）")
    private Integer status;

    @ApiModelProperty("提示消息")
    private String hintMessage;

    @ApiModelProperty("登录时间")
    private Date gmtLogin;
}
