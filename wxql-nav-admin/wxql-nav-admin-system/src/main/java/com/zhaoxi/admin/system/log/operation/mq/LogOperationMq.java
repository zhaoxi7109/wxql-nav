package com.zhaoxi.admin.system.log.operation.mq;

import com.alibaba.fastjson.JSONObject;
import com.zhaoxi.admin.system.log.operation.mapstruct.LogOperationConverter;
import com.zhaoxi.admin.system.log.operation.po.LogOperation;
import com.zhaoxi.admin.system.log.operation.service.LogOperationService;
import com.zhaoxi.common.core.util.id.IdWorker;
import com.zhaoxi.common.log.dto.LogDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 操作日志消息中心
 *
 * @author zhaoxi
 * @date 2022/7/5
 */
@Component
public class LogOperationMq {

    @Autowired
    private LogOperationService logOperationService;

    /**
     * 消费消息中心日志
     */
    public void consumeMqLog(String message) {
        LogDTO logDto = JSONObject.parseObject(message, LogDTO.class);
        LogOperation logOperation = LogOperationConverter.INSTANCE.convert(logDto);
        logOperation.setId(IdWorker.nextId());
        logOperationService.save(logOperation);
    }

}
