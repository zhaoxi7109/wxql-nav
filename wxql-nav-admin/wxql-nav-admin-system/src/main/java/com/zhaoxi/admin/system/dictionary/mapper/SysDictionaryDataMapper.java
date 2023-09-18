package com.zhaoxi.admin.system.dictionary.mapper;

import com.zhaoxi.admin.system.dictionary.po.SysDictionaryData;
import com.zhaoxi.common.framework.web.mapper.BaseMapperPlus;
import org.apache.ibatis.annotations.Mapper;

/**
 * 字典数据
 *
 * @author zhaoxi
 * @date 2022/6/27
 */
@Mapper
public interface SysDictionaryDataMapper extends BaseMapperPlus<SysDictionaryData> {

    /**
     * 获取最大排序
     * @param dictionaryId 字典 id
     */
    Integer selectMaxSortByDictionaryId(Long dictionaryId);

}
