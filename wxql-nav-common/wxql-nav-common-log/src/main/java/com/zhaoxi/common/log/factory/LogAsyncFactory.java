package com.zhaoxi.common.log.factory;

import com.zhaoxi.common.core.util.ip.AddressUtils;
import com.zhaoxi.common.core.util.servlet.ServletUtils;
import com.zhaoxi.common.core.util.spring.SpringUtils;
import com.zhaoxi.common.log.dto.LogDTO;
import com.zhaoxi.common.log.service.LogMqService;
import eu.bitwalker.useragentutils.UserAgent;

import java.util.TimerTask;

/**
 * 日志异步工厂
 *
 * @author zhaoxi
 * @date 2022/7/5
 */
public class LogAsyncFactory {

    /**
     * 添加日志到 Redis 消息队列，以免大量操作影响数据库性能
     * @param logDTO
     * @return
     */
    public static TimerTask addLog(LogDTO logDTO) {
        // 获取客户端信息
        UserAgent userAgent = UserAgent.parseUserAgentString(ServletUtils.getRequest().getHeader("User-Agent"));
        return new TimerTask() {
            @Override
            public void run() {
                // 获取客户端操作系统
                String operateSystem = userAgent.getOperatingSystem().getName();
                // 获取客户端浏览器
                String browser = userAgent.getBrowser().getName();
                logDTO.setBrowserType(browser);
                logDTO.setOperateSystem(operateSystem);
                // 获取远程查询操作地点
                logDTO.setOperateLocation(AddressUtils.getRealAddressByIP(logDTO.getIpAddress()));
                // 添加到消息队列
                SpringUtils.getBean(LogMqService.class).addLogToMq(logDTO);
            }
        };
    }

}
