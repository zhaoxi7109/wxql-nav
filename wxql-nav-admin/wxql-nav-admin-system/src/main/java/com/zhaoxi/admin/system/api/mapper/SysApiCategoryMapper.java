package com.zhaoxi.admin.system.api.mapper;

import com.zhaoxi.admin.system.api.po.SysApiCategory;
import com.zhaoxi.common.framework.web.mapper.BaseMapperPlus;
import org.apache.ibatis.annotations.Mapper;

/**
 * 系统接口分类
 *
 * @author zhaoxi
 * @date 2022/6/24
 */
@Mapper
public interface SysApiCategoryMapper extends BaseMapperPlus<SysApiCategory> {

    /**
     * 获取最大排序
     */
    Integer selectMaxSort();
}
