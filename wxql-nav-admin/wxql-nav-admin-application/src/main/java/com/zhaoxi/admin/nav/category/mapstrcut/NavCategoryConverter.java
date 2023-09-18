package com.zhaoxi.admin.nav.category.mapstrcut;

import com.zhaoxi.admin.client.nav.vo.NavCategoryClientVO;
import com.zhaoxi.admin.client.nav.vo.NavCategorySiteClientVO;
import com.zhaoxi.admin.nav.category.dto.NavCategoryAddDTO;
import com.zhaoxi.admin.nav.category.dto.NavCategoryUpdateDTO;
import com.zhaoxi.admin.nav.category.po.NavCategory;
import com.zhaoxi.admin.nav.category.vo.NavCategoryTreeVO;
import com.zhaoxi.admin.nav.category.vo.NavCategoryVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 导航分类对象转换
 *
 * @author zhaoxi
 */
@Mapper
public interface NavCategoryConverter {

    NavCategoryConverter INSTANCE = Mappers.getMapper(NavCategoryConverter.class);

    List<NavCategoryVO> convert(List<NavCategory> list);

    List<NavCategoryTreeVO> convertTree(List<NavCategory> list);

    NavCategoryVO convert(NavCategory navCategory);

    NavCategory convert(NavCategoryAddDTO addDTO);

    NavCategory convert(NavCategoryUpdateDTO updateDTO);

    List<NavCategoryClientVO> convertClient(List<NavCategoryTreeVO> list);

    List<NavCategorySiteClientVO> convertSiteClient(List<NavCategoryClientVO> list);

}