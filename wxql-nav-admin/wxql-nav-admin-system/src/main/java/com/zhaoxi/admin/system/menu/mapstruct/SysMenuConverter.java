package com.zhaoxi.admin.system.menu.mapstruct;

import com.zhaoxi.admin.system.menu.dto.SysMenuAddDTO;
import com.zhaoxi.admin.system.menu.dto.SysMenuUpdateDTO;
import com.zhaoxi.admin.system.menu.po.SysMenu;
import com.zhaoxi.admin.system.menu.vo.SysMenuVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 菜单对象转换
 *
 * @author zhaoxi
 */
@Mapper
public interface SysMenuConverter {

    SysMenuConverter INSTANCE = Mappers.getMapper(SysMenuConverter.class);

    SysMenuVO convert(SysMenu menus);

    List<SysMenuVO> convertList(List<SysMenu> menus);

    SysMenu convert(SysMenuAddDTO addDto);

    SysMenu convert(SysMenuUpdateDTO updateDto);

}
