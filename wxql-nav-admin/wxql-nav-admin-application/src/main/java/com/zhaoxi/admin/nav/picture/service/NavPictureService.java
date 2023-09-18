package com.zhaoxi.admin.nav.picture.service;

import com.zhaoxi.admin.nav.picture.po.NavPicture;
import com.zhaoxi.common.framework.web.service.BaseService;
import org.springframework.web.multipart.MultipartFile;

/**
 * 导航图片
 *
 * @author zhaoxi
 */
public interface NavPictureService extends BaseService<NavPicture> {

    /**
     * 获取图片上传路径
     *
     * @param modulePath 模块路径
     * @param file 文件
     */
    NavPicture getUploadFilePath(String modulePath, MultipartFile file);

}
