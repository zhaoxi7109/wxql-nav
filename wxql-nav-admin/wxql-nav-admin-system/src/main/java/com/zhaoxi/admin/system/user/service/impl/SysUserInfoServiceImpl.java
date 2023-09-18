package com.zhaoxi.admin.system.user.service.impl;

import com.zhaoxi.admin.system.user.mapstruct.SysUserConverter;
import com.zhaoxi.admin.system.user.po.SysUser;
import com.zhaoxi.admin.system.user.service.SysUserInfoService;
import com.zhaoxi.admin.system.user.service.SysUserService;
import com.zhaoxi.admin.system.user.vo.SysUserVO;
import com.zhaoxi.framework.security.domain.LoginUserDetail;
import com.zhaoxi.framework.security.service.TokenService;
import com.zhaoxi.framework.security.util.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 用户信息
 *
 * @author zhaoxi
 * @date 2022/3/27
 */
@Service
public class SysUserInfoServiceImpl implements SysUserInfoService {

    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private TokenService tokenService;

    /**
     * 获取用户信息
     */
    @Override
    public SysUserVO getUserInfo() {
        LoginUserDetail loginUser = SecurityUtils.getLoginUser();

        // 重新获取用户信息，当有权限发生改变时，不用重新登录就能生效
        SysUser sysUser = sysUserService.getById(loginUser.getUserId());
        loginUser = SysUserConverter.INSTANCE.convertDetail(sysUser);
        // 设置用户权限
        sysUserService.setLoginUserPermission(loginUser);

        // 重新设置用户权限到 Redis 缓存
        String token = tokenService.getToken();
        // 获取令牌有效期
        Long expireTime = tokenService.getTokenExpireTime(token);
        tokenService.setLoginUserCache(token, loginUser, expireTime);

        // 设置返回的数据
        SysUserVO sysUserVo = SysUserConverter.INSTANCE.convert(sysUser);
        sysUserVo.setPassword("");
        sysUserVo.setPermissionCodes(loginUser.getPermissionCodes());
        sysUserVo.setRoleCodes(loginUser.getRoleCodes());
        return sysUserVo;
    }
}
