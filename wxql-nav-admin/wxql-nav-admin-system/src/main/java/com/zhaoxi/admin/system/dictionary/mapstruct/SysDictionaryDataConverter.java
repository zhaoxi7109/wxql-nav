package com.zhaoxi.admin.system.dictionary.mapstruct;

import com.zhaoxi.admin.system.dictionary.dto.SysDictionaryDataAddDTO;
import com.zhaoxi.admin.system.dictionary.dto.SysDictionaryDataUpdateDTO;
import com.zhaoxi.admin.system.dictionary.po.SysDictionaryData;
import com.zhaoxi.admin.system.dictionary.vo.SysDictionaryDataVO;
import com.zhaoxi.common.framework.mybatis.page.vo.PageVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * 字典数据对象转换
 *
 * @author zhaoxi
 * @date 2022/6/27
 */
@Mapper
public interface SysDictionaryDataConverter {

    SysDictionaryDataConverter INSTANCE = Mappers.getMapper(SysDictionaryDataConverter.class);

    SysDictionaryDataVO convert(SysDictionaryData sysDictionaryData);

    PageVO<SysDictionaryDataVO> convert(PageVO<SysDictionaryData> pageVo);

    SysDictionaryData convert(SysDictionaryDataAddDTO addDTO);

    SysDictionaryData convert(SysDictionaryDataUpdateDTO updateDTO);

}
