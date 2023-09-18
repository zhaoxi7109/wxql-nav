package com.zhaoxi.admin.nav.site.mapstrcut;

import com.zhaoxi.admin.nav.site.dto.NavSiteAddDTO;
import com.zhaoxi.admin.nav.site.dto.NavSiteUpdateDTO;
import com.zhaoxi.admin.nav.site.dto.NavSiteUpdateSortDTO;
import com.zhaoxi.admin.nav.site.po.NavSite;
import com.zhaoxi.admin.nav.site.vo.NavSiteClientVO;
import com.zhaoxi.admin.nav.site.vo.NavSiteLatestCollectVO;
import com.zhaoxi.admin.nav.site.vo.NavSiteMatchVO;
import com.zhaoxi.admin.nav.site.vo.NavSiteVO;
import com.zhaoxi.common.framework.mybatis.page.vo.PageVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 导航网站对象转换
 *
 * @author zhaoxi
 */
@Mapper
public interface NavSiteConverter {

    NavSiteConverter INSTANCE = Mappers.getMapper(NavSiteConverter.class);

    PageVO<NavSiteVO> convert(PageVO<NavSite> pageVO);

    NavSiteVO convert(NavSite navSite);

    NavSite convert(NavSiteAddDTO addDTO);

    NavSite convert(NavSiteUpdateDTO updateDTO);

    NavSiteMatchVO convertMatch(NavSite navSite);

    List<NavSite> convert(List<NavSiteUpdateSortDTO> list);

    List<NavSiteClientVO> convertCilent(List<NavSite> list);

    List<NavSiteLatestCollectVO> convertCollect(List<NavSite> list);

}