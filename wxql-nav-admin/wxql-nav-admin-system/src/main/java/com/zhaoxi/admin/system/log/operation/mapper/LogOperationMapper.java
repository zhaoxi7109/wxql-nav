package com.zhaoxi.admin.system.log.operation.mapper;

import com.zhaoxi.admin.system.log.operation.dto.LogOperationPageDTO;
import com.zhaoxi.admin.system.log.operation.po.LogOperation;
import com.zhaoxi.admin.system.log.operation.vo.LogOperationVo;
import com.zhaoxi.common.framework.web.mapper.BaseMapperPlus;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 操作日志
 *
 * @author zhaoxi
 * @date 2022/7/5
 */
@Mapper
public interface LogOperationMapper extends BaseMapperPlus<LogOperation> {

    /**
     * 分页列表
     */
    List<LogOperationVo> pageList(LogOperationPageDTO pageDto);
}
