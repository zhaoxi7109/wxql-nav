package com.zhaoxi.admin.system.role.mapper;

import com.zhaoxi.admin.system.role.po.SysRole;
import com.zhaoxi.admin.system.role.vo.SysRoleVO;
import com.zhaoxi.common.framework.web.mapper.BaseMapperPlus;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 系统角色
 *
 * @author zhaoxi
 */
@Mapper
public interface SysRoleMapper extends BaseMapperPlus<SysRole> {

    /**
     * 通过用户 id 获取角色
     * @param userId 用户 id
     * @param status 角色状态
     */
    List<SysRoleVO> getRoleByUserIds(@Param("userIds") List<Long> userId, @Param("status") Integer status);

    /**
     * 获取最大排序
     */
    Integer selectMaxSort();
}
