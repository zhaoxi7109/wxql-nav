package com.zhaoxi.common.log.service;

import com.zhaoxi.common.log.dto.LogDTO;

/**
 * 日志消息中心
 *
 * @author zhaoxi
 * @date 2022/7/5
 */
public interface LogMqService {

    /**
     * 添加日志消息中心
     */
    void addLogToMq(LogDTO logDTO);

}
