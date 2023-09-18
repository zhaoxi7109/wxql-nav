package com.zhaoxi.admin.system.api.mapstruct;

import com.zhaoxi.admin.system.api.dto.SysApiAddDTO;
import com.zhaoxi.admin.system.api.dto.SysApiUpdateDTO;
import com.zhaoxi.admin.system.api.po.SysApi;
import com.zhaoxi.admin.system.api.vo.SysApiVO;
import com.zhaoxi.common.framework.mybatis.page.vo.PageVO;
import com.zhaoxi.framework.security.domain.ApiPermission;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 接口对象转换
 *
 * @author zhaoxi
 */
@Mapper
public interface SysApiConverter {

    SysApiConverter INSTANCE = Mappers.getMapper(SysApiConverter.class);

    List<ApiPermission> convertList(List<SysApiVO> list);

    PageVO<SysApiVO> convert(PageVO<SysApi> pageVo);

    SysApiVO convert(SysApi sysApi);

    SysApi convert(SysApiAddDTO addDTO);

    SysApi convert(SysApiUpdateDTO updateDTO);
}
