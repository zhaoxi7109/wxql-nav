package com.zhaoxi.admin.system.api.service;

import com.zhaoxi.admin.system.api.po.SysApiCategory;
import com.zhaoxi.admin.system.api.vo.SysApiCategoryVO;
import com.zhaoxi.common.framework.web.service.BaseService;

import java.util.List;

/**
 * 系统接口分类
 *
 * @author zhaoxi
 * @date 2022/6/24
 */
public interface SysApiCategoryService extends BaseService<SysApiCategory> {

    /**
     * 列表排序
     */
    List<SysApiCategoryVO> listSort();

    /**
     * 删除
     */
    void removeByIds(Long[] ids);

    /**
     * 获取最大排序
     */
    Integer getMaxSort();
}
