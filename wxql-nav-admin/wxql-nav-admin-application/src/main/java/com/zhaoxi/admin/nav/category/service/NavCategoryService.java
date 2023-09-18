package com.zhaoxi.admin.nav.category.service;

import com.zhaoxi.admin.nav.category.dto.NavCategoryUpdateDTO;
import com.zhaoxi.admin.nav.category.po.NavCategory;
import com.zhaoxi.admin.nav.category.vo.NavCategoryTreeVO;
import com.zhaoxi.common.framework.web.service.BaseService;

import java.util.List;

/**
 * 导航分类
 *
 * @author zhaoxi
 */
public interface NavCategoryService extends BaseService<NavCategory> {

    /**
     * 获取最大排序
     * @param parentId 上级分类 id
     */
    Integer getMaxSortByParentId(Long parentId);

    /**
     * 树形
     */
    List<NavCategoryTreeVO> tree();

    /**
     * 树形
     */
    List<NavCategoryTreeVO> treeByIds(List<Long> ids);

    /**
     * 更新
     */
    void updateById(NavCategoryUpdateDTO updateDTO);

    /**
     * 删除
     */
    void remove(Long id);

}
