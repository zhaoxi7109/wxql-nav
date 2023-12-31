package com.zhaoxi.admin.core.security.auth.controller;

import com.zhaoxi.admin.core.security.auth.dto.AuthLoginDTO;
import com.zhaoxi.admin.core.security.auth.service.AuthService;
import com.zhaoxi.admin.core.security.auth.vo.AuthLoginVO;
import com.zhaoxi.common.core.web.response.ResponseResult;
import com.zhaoxi.common.framework.web.controller.BaseController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * 认证中心
 *
 * @author zhaoxi
 */
@RestController
@Api(tags = "认证中心")
public class AuthController extends BaseController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    @ApiOperation("登录")
    public ResponseResult<AuthLoginVO> login(@Valid @RequestBody AuthLoginDTO authLoginDTO) {
        AuthLoginVO authLoginVO = authService.login(authLoginDTO);
        return ResponseResult.success(authLoginVO);
    }


}
