package com.zhaoxi.admin.core.security.auth.service;

import com.zhaoxi.admin.core.security.auth.dto.AuthLoginDTO;
import com.zhaoxi.admin.core.security.auth.vo.AuthLoginVO;

/**
 * 认证中心
 *
 * @author zhaoxi
 */
public interface AuthService {

    /**
     * 登录
     */
    AuthLoginVO login(AuthLoginDTO authLoginDTO);
}
