package com.zhaoxi.admin.system.param.mapper;

import com.zhaoxi.admin.system.param.po.SysParam;
import com.zhaoxi.common.framework.web.mapper.BaseMapperPlus;
import org.apache.ibatis.annotations.Mapper;

/**
 * 参数配置
 *
 * @author zhaoxi
 * @date 2022/8/16
 */
@Mapper
public interface SysParamMapper extends BaseMapperPlus<SysParam> {

    /**
     * 获取最大排序
     */
    Integer selectMaxSort();
}
