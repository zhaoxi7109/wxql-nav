package com.zhaoxi.admin.system.param.mapstruct;

import com.zhaoxi.admin.system.param.dto.SysParamAddDTO;
import com.zhaoxi.admin.system.param.dto.SysParamUpdateDTO;
import com.zhaoxi.admin.system.param.po.SysParam;
import com.zhaoxi.admin.system.param.vo.SysParamVO;
import com.zhaoxi.common.framework.mybatis.page.vo.PageVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * 参数配置对象转换
 *
 * @author zhaoxi
 * @date 2022/8/16
 */
@Mapper
public interface SysParamConverter {

    SysParamConverter INSTANCE = Mappers.getMapper(SysParamConverter.class);

    PageVO<SysParamVO> convert(PageVO<SysParam> pageVO);

    SysParamVO convert(SysParam sysParam);

    SysParam convert(SysParamAddDTO addDTO);

    SysParam convert(SysParamUpdateDTO updateDTO);

}
