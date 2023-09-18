package com.zhaoxi.admin.system.api.mapper;

import com.zhaoxi.admin.system.api.po.SysApi;
import com.zhaoxi.admin.system.api.vo.SysApiVO;
import com.zhaoxi.admin.system.menu.vo.SysMenuAuthApiVO;
import com.zhaoxi.common.framework.web.mapper.BaseMapperPlus;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 接口
 *
 * @author zhaoxi
 */
@Mapper
public interface SysApiMapper extends BaseMapperPlus<SysApi> {

    /**
     * 通过菜单 id 列表获取接口
     * @param menuIds 菜单 id 列表
     * @param status 状态
     * @return
     */
    List<SysApiVO> getApiByMenuIds(@Param("menuIds") List<Long> menuIds,
                                   @Param("status") Integer status);

    /**
     * 获取最大排序
     * @param apiCategoryId 分类 id
     */
    Integer selectMaxSortByCategoryId(Long apiCategoryId);

    /**
     * 获取分配的 API 接口
     * @param menuId 菜单 id
     * @return
     */
    List<SysMenuAuthApiVO> selectAuthApiByMenuId(Long menuId);
}
