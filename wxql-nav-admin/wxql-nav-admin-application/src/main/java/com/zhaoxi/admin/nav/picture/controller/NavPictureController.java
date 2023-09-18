package com.zhaoxi.admin.nav.picture.controller;

import com.zhaoxi.admin.nav.picture.constant.NavPictureConstant;
import com.zhaoxi.admin.nav.picture.po.NavPicture;
import com.zhaoxi.admin.nav.picture.service.NavPictureService;
import com.zhaoxi.admin.nav.picture.vo.NavPictureUploadVO;
import com.zhaoxi.admin.system.user.service.SysUserService;
import com.zhaoxi.common.core.web.response.ResponseResult;
import com.zhaoxi.common.framework.web.controller.BaseController;
import com.zhaoxi.common.log.annotation.Log;
import com.zhaoxi.common.log.enums.BusinessType;
import com.zhaoxi.framework.security.util.SecurityUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * 导航图片
 *
 * @author zhaoxi
 */
@Api(tags = "导航图片")
@RestController
@RequestMapping("/nav/picture")
public class NavPictureController extends BaseController {

    @Autowired
    private NavPictureService navPictureService;
    @Autowired
    private SysUserService sysUserService;

    @ApiOperation("上传")
    @PostMapping("/upload")
    @PreAuthorize("@auth.hasUrl()")
    public ResponseResult<NavPictureUploadVO> upload(MultipartFile file) {
        NavPicture navPicture = navPictureService.getUploadFilePath(NavPictureConstant.SITE_CONFIG_PREFIX, file);
        return ResponseResult.success(new NavPictureUploadVO(navPicture.getPictureOriginalName(), navPicture.getPicturePath()));
    }

    @ApiOperation("系统网站上传")
    @PostMapping("/site/upload")
    @PreAuthorize("@auth.hasUrl()")
    @Log(moduleName = "导航图片-系统网站上传", businessType = BusinessType.ADD, isSaveRequestData = false)
    public ResponseResult<NavPictureUploadVO> uploadSite(MultipartFile file) {
        NavPicture navPicture = navPictureService.getUploadFilePath(NavPictureConstant.SYSTEM_SITE_PREFIX, file);
        return ResponseResult.success(new NavPictureUploadVO(navPicture.getPictureOriginalName(), navPicture.getPicturePath()));
    }

    @ApiOperation("用户头像上传")
    @PostMapping("/upload/avatar")
    @Log(moduleName = "导航图片-用户头像上传", businessType = BusinessType.ADD, isSaveRequestData = false)
    public ResponseResult<NavPictureUploadVO> uploadAvatar(MultipartFile file) {
        NavPicture navPicture = navPictureService.getUploadFilePath(NavPictureConstant.AVATAR_PREFIX, file);
        sysUserService.updateAvatarById(SecurityUtils.getUserId(), navPicture.getPicturePath());
        return ResponseResult.success(new NavPictureUploadVO(navPicture.getPictureOriginalName(), navPicture.getPicturePath()));
    }

}
