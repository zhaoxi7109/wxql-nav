package com.zhaoxi.admin.nav.picture.mapstrcut;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * 导航图片对象转换
 *
 * @author zhaoxi
 */
@Mapper
public interface NavPictureConverter {

    NavPictureConverter INSTANCE = Mappers.getMapper(NavPictureConverter.class);

}