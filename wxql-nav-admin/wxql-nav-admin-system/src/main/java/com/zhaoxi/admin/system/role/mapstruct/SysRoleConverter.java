package com.zhaoxi.admin.system.role.mapstruct;

import com.zhaoxi.admin.system.role.dto.SysRoleAddDTO;
import com.zhaoxi.admin.system.role.dto.SysRoleAuthUserPageDTO;
import com.zhaoxi.admin.system.role.dto.SysRoleNotAuthUserPageDTO;
import com.zhaoxi.admin.system.role.dto.SysRoleUpdateDTO;
import com.zhaoxi.admin.system.role.po.SysRole;
import com.zhaoxi.admin.system.role.vo.SysRoleVO;
import com.zhaoxi.admin.system.user.dto.SysUserPageDTO;
import com.zhaoxi.common.framework.mybatis.page.vo.PageVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * 角色对象转换
 *
 * @author zhaoxi
 * @date 2022/6/19
 */
@Mapper
public interface SysRoleConverter {

    SysRoleConverter INSTANCE = Mappers.getMapper(SysRoleConverter.class);

    SysRoleVO convert(SysRole sysRole);

    PageVO<SysRoleVO> convert(PageVO<SysRole> pageVO);

    SysRole convert(SysRoleAddDTO addDTO);

    SysRole convert(SysRoleUpdateDTO updateDTO);

    SysUserPageDTO convert(SysRoleAuthUserPageDTO pageDTO);

    SysUserPageDTO convert(SysRoleNotAuthUserPageDTO pageDTO);

}
