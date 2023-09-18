package com.zhaoxi.admin.system.log.operation.mapstruct;

import com.zhaoxi.admin.system.log.operation.po.LogOperation;
import com.zhaoxi.admin.system.log.operation.vo.LogOperationVo;
import com.zhaoxi.common.log.dto.LogDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * 操作日志转换
 *
 * @author zhaoxi
 * @date 2022/7/9
 */
@Mapper
public interface LogOperationConverter {

    LogOperationConverter INSTANCE = Mappers.getMapper(LogOperationConverter.class);

    LogOperationVo convert(LogOperation logOperation);

    LogOperation convert(LogDTO logDto);

}
