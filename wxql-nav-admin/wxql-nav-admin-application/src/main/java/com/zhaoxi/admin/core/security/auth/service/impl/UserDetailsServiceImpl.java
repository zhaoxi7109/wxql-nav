package com.zhaoxi.admin.core.security.auth.service.impl;

import com.zhaoxi.admin.system.user.service.SysUserService;
import com.zhaoxi.common.core.exception.ServiceException;
import com.zhaoxi.common.core.util.message.MessageUtils;
import com.zhaoxi.framework.security.domain.LoginUserDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * 用户验证处理
 *
 * @author zhaoxi
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private SysUserService sysUserService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 获取登录用户
        LoginUserDetail loginUserDetail = sysUserService.getLoginUserByUsername(username);
        if (loginUserDetail == null) {
            throw new ServiceException(MessageUtils.message("login.username.password.not.match"));
        }
        return loginUserDetail;
    }
}
