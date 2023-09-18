package com.zhaoxi.admin.nav.category.mapper;

import com.zhaoxi.admin.nav.category.po.NavCategory;
import com.zhaoxi.common.framework.web.mapper.BaseMapperPlus;
import org.apache.ibatis.annotations.Mapper;

/**
 * 导航分类
 *
 * @author zhaoxi
 */
@Mapper
public interface NavCategoryMapper extends BaseMapperPlus<NavCategory> {

    /**
     * 获取最大排序
     * @param parentId 上级分类 id
     */
    Integer selectMaxSortByParentId(Long parentId);

}