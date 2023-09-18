package com.zhaoxi.admin.system.dictionary.service;

import com.zhaoxi.admin.system.dictionary.po.SysDictionary;
import com.zhaoxi.admin.system.dictionary.vo.DictionaryInfoVO;
import com.zhaoxi.admin.system.dictionary.vo.SysDictionaryVO;
import com.zhaoxi.common.framework.web.service.BaseService;

import java.util.List;

/**
 * 字典
 *
 * @author zhaoxi
 * @date 2022/6/26
 */
public interface SysDictionaryService extends BaseService<SysDictionary> {

    /**
     * 列表排序
     */
    List<SysDictionaryVO> listSort();

    /**
     * 删除
     */
    void removeByIds(Long[] ids);

    /**
     * 获取最大排序
     */
    Integer getMaxSort();

    /**
     * 获取所有字典详细信息
     */
    List<DictionaryInfoVO> getAllDictionaryInfo();
}
