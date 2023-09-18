package com.zhaoxi.framework.security.util;

import com.zhaoxi.common.core.constant.HttpStatus;
import com.zhaoxi.common.core.exception.ServiceException;
import com.zhaoxi.common.core.util.message.MessageUtils;
import com.zhaoxi.framework.security.domain.LoginUserDetail;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * 安全工具类
 *
 * @author zhaoxi
 * @date 2022/3/25
 */
public class SecurityUtils {

    /**
     * 获取用户 id
     */
    public static Long getUserId() {
        return getLoginUser().getUserId();
    }

    /**
     * 获取用户名
     */
    public static String getUsername() {
        return getLoginUser().getUsername();
    }

    /**
     * 获取登录用户
     */
    public static LoginUserDetail getLoginUser() {
        try {
            return (LoginUserDetail) getAuthentication().getPrincipal();
        } catch (Exception e) {
            throw new ServiceException(HttpStatus.UNAUTHORIZED, MessageUtils.message("user.info.fail"));
        }
    }

    /**
     * 获取 Authentication
     */
    public static Authentication getAuthentication() {
        return SecurityContextHolder.getContext().getAuthentication();
    }


    /**
     * 生成 BCryptPasswordEncoder 加密密码
     * @param password
     */
    public static String encryptPassword(String password) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return bCryptPasswordEncoder.encode(password);
    }

    /**
     * 判断密码是否相同
     *
     * @param rawPassword 真实密码
     * @param encodedPassword 加密后字符
     * @return 结果
     */
    public static boolean matchesPassword(String rawPassword, String encodedPassword) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.matches(rawPassword, encodedPassword);
    }

}
