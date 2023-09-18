package com.zhaoxi.admin.core.captcha.controller;

import com.zhaoxi.admin.core.captcha.constant.CaptchaConstant;
import com.zhaoxi.admin.core.captcha.vo.CaptchaImageVO;
import com.zhaoxi.common.core.util.id.IdUtils;
import com.zhaoxi.common.core.web.response.ResponseResult;
import com.zhaoxi.common.framework.web.controller.BaseController;
import com.zhaoxi.common.rate.limiter.annotation.RateLimiter;
import com.zhaoxi.common.rate.limiter.enums.RateLimiterType;
import com.zhaoxi.common.redis.service.RedisService;
import com.wf.captcha.SpecCaptcha;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * 验证码
 * @author zhaoxi
 */
@RestController
@Api(tags = "验证码")
public class CaptchaController extends BaseController {

    @Autowired
    private RedisService redisService;

    @ApiOperation("获取验证码")
    @GetMapping("/getCaptchaImage")
    @RateLimiter(type = RateLimiterType.IP, hintMessage = "验证码获取频繁，请稍后再试")
    public ResponseResult<CaptchaImageVO> getCode() {
        String uuid = IdUtils.simpleUUID();
        String verifyKey = CaptchaConstant.CAPTCHA_CODE_KEY + uuid;
        SpecCaptcha specCaptcha = new SpecCaptcha(105, 38, 4);
        String code = specCaptcha.text();
        // 保存验证码信息
        redisService.set(verifyKey, code, CaptchaConstant.CAPTCHA_EXPIRATION, TimeUnit.MINUTES);
        CaptchaImageVO captchaImageVO = new CaptchaImageVO();
        captchaImageVO.setUuid(uuid);
        captchaImageVO.setImage(specCaptcha.toBase64());
        return ResponseResult.success(captchaImageVO);
    }

}
