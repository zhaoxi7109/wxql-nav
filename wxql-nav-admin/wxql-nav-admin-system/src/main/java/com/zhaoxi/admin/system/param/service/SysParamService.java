package com.zhaoxi.admin.system.param.service;

import com.zhaoxi.admin.system.param.dto.SysParamAddDTO;
import com.zhaoxi.admin.system.param.dto.SysParamUpdateDTO;
import com.zhaoxi.admin.system.param.po.SysParam;
import com.zhaoxi.common.framework.web.service.BaseService;

/**
 * 参数配置
 *
 * @author zhaoxi
 * @date 2022/8/16
 */
public interface SysParamService extends BaseService<SysParam> {

    /**
     * 新增
     */
    void save(SysParamAddDTO addDTO);

    /**
     * 更新
     */
    void updateById(SysParamUpdateDTO updateDTO);

    /**
     * 删除
     */
    void removeByIds(Long[] ids);

    /**
     * 获取最大排序
     */
    Integer getMaxSort();

    /**
     * 获取参数值
     *
     * @param paramKey 参数键
     */
    String getParamValueByKey(String paramKey);

    /**
     * 清除缓存
     *
     * @param paramKey 参数键
     */
    void removeCache(String paramKey);
}
