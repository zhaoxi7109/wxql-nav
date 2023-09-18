package com.zhaoxi.admin.client.nav.mapstruct;

import com.zhaoxi.admin.client.nav.vo.NavCategoryClientVO;
import com.zhaoxi.admin.nav.category.po.NavCategory;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 导航客户端对象转换
 *
 * @author zhaoxi
 */
@Mapper
public interface ClientNavConverter {

    ClientNavConverter INSTANCE = Mappers.getMapper(ClientNavConverter.class);

    List<NavCategoryClientVO> convertCategory(List<NavCategory> list);

}
