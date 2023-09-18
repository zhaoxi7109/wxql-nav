package com.zhaoxi.admin.client.search.controller;

import com.zhaoxi.admin.client.nav.service.ClientNavService;
import com.zhaoxi.admin.client.nav.vo.NavClientListVO;
import com.zhaoxi.admin.client.search.vo.NavClientSiteSearchVO;
import com.zhaoxi.admin.nav.site.service.NavSiteService;
import com.zhaoxi.common.core.web.response.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 客户端搜索
 *
 * @author zhaoxi
 */
@Api(tags = "客户端搜索")
@RestController
@RequestMapping("/client/search")
public class ClientSearchController {

    @Autowired
    private NavSiteService navSiteService;
    @Autowired
    private ClientNavService clientNavService;

    @ApiOperation("站内网站搜索")
    @GetMapping("/site/list")
    public ResponseResult<List<NavClientSiteSearchVO>> siteSearch(String searchContent) {
        List<NavClientSiteSearchVO> list = navSiteService.siteSearch(searchContent);
        return ResponseResult.success(list);
    }

    @ApiOperation("站内分类网站搜索列表")
    @GetMapping("/category/site/list")
    public ResponseResult<NavClientListVO> categorySiteSearchList(String searchContent) {
        NavClientListVO listVO = clientNavService.categorySiteSearchList(searchContent);
        return ResponseResult.success(listVO);
    }
}
