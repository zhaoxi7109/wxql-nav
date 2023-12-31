package com.zhaoxi.framework.security.handler;

import com.zhaoxi.common.core.util.servlet.ServletUtils;
import com.zhaoxi.common.core.web.response.ResponseResult;
import com.zhaoxi.framework.security.domain.LoginUserDetail;
import com.zhaoxi.framework.security.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 自定义退出处理
 *
 * @author zhaoxi
 */
@Component
public class LogoutSuccessHandlerImpl implements LogoutSuccessHandler {

    @Autowired
    private TokenService tokenService;


    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        // 获取当前登录用户
        LoginUserDetail loginUser = tokenService.getLoginUser(request);
        if (loginUser != null) {
            // 删除登录用户
            tokenService.deleteLoginUser(request, loginUser.getUserId());
        }
        ServletUtils.renderString(ResponseResult.success(), response);
    }
}
