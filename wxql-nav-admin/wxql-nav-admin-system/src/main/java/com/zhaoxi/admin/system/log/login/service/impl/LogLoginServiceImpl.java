package com.zhaoxi.admin.system.log.login.service.impl;

import com.zhaoxi.admin.system.log.login.mapper.LogLoginMapper;
import com.zhaoxi.admin.system.log.login.po.LogLogin;
import com.zhaoxi.admin.system.log.login.service.LogLoginService;
import com.zhaoxi.common.framework.web.service.impl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 登录日志
 *
 * @author zhaoxi
 * @date 2022/7/3
 */
@Service
public class LogLoginServiceImpl extends BaseServiceImpl<LogLoginMapper, LogLogin> implements LogLoginService {

    @Autowired
    private LogLoginMapper logLoginMapper;

}
