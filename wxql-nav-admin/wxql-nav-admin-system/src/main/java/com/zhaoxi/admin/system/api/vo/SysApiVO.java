package com.zhaoxi.admin.system.api.vo;

import com.zhaoxi.common.core.web.vo.BaseVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 接口
 *
 * @author zhaoxi
 */
@Data
@ApiModel("接口")
public class SysApiVO extends BaseVO implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("接口id")
    private Long id;

    @ApiModelProperty("接口名称")
    private String apiName;

    @ApiModelProperty("接口地址")
    private String apiUrl;

    @ApiModelProperty("接口请求方式（如：get，post）")
    private String apiMethod;

    @ApiModelProperty("所属分类")
    private Long apiCategoryId;

    @ApiModelProperty("排序")
    private Integer sort;

    @ApiModelProperty("状态（1 正常，2 停用）")
    private Integer status;

    @ApiModelProperty("备注")
    private String remark;

}
