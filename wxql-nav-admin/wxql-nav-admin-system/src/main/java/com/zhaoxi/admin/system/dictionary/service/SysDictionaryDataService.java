package com.zhaoxi.admin.system.dictionary.service;

import com.zhaoxi.admin.system.dictionary.po.SysDictionaryData;
import com.zhaoxi.common.framework.web.service.BaseService;

/**
 * 字典数据
 *
 * @author zhaoxi
 * @date 2022/6/27
 */
public interface SysDictionaryDataService extends BaseService<SysDictionaryData> {

    /**
     * 获取最大排序
     * @param dictionaryId 字典 id
     */
    Integer getMaxSortByDictionaryId(Long dictionaryId);

}
