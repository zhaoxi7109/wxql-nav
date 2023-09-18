package com.zhaoxi.admin.nav.comment.controller;

import com.zhaoxi.admin.nav.comment.dto.NavCommentPageDTO;
import com.zhaoxi.admin.nav.comment.dto.NavCommentRejectDTO;
import com.zhaoxi.admin.nav.comment.service.NavCommentService;
import com.zhaoxi.admin.nav.comment.vo.NavCommentVO;
import com.zhaoxi.common.core.enums.YesNo;
import com.zhaoxi.common.core.web.response.ResponseResult;
import com.zhaoxi.common.framework.mybatis.page.vo.PageVO;
import com.zhaoxi.common.log.annotation.Log;
import com.zhaoxi.common.log.enums.BusinessType;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Arrays;

/**
 * 评论
 *
 * @author zhaoxi
 */
@Api(tags = "评论")
@RestController
@RequestMapping("/nav/comment")
public class NavCommentController {

    @Autowired
    private NavCommentService navCommentService;

    @ApiOperation("分页列表")
    @GetMapping("/page")
    @PreAuthorize("@auth.hasUrl()")
    public ResponseResult<PageVO<NavCommentVO>> page(NavCommentPageDTO pageDTO) {
        PageVO<NavCommentVO> pageVO = navCommentService.pageList(pageDTO);
        return ResponseResult.success(pageVO);
    }


    @ApiOperation("通过")
    @PutMapping("/pass/{ids}")
    @PreAuthorize("@auth.hasUrl()")
    @Log(moduleName = "评论-通过", businessType = BusinessType.UPDATE)
    public ResponseResult pass(@PathVariable Long[] ids) {
        navCommentService.pass(ids);
        return ResponseResult.success();
    }

    @ApiOperation("驳回")
    @PutMapping("/reject")
    @PreAuthorize("@auth.hasUrl()")
    @Log(moduleName = "评论-驳回", businessType = BusinessType.UPDATE)
    public ResponseResult reject(@Valid @RequestBody NavCommentRejectDTO rejectDTO) {
        navCommentService.reject(rejectDTO);
        return ResponseResult.success();
    }

    @ApiOperation("置顶")
    @PutMapping("/sticky/{id}")
    @PreAuthorize("@auth.hasUrl()")
    @Log(moduleName = "评论-置顶", businessType = BusinessType.UPDATE)
    public ResponseResult pass(@PathVariable Long id) {
        navCommentService.updateSticky(id, YesNo.YES.code);
        return ResponseResult.success();
    }

    @ApiOperation("取消置顶")
    @PutMapping("/cancelSticky/{id}")
    @PreAuthorize("@auth.hasUrl()")
    @Log(moduleName = "评论-取消置顶", businessType = BusinessType.UPDATE)
    public ResponseResult cancelSticky(@PathVariable Long id) {
        navCommentService.updateSticky(id, YesNo.NO.code);
        return ResponseResult.success();
    }

    @DeleteMapping("/delete/{ids}")
    @ApiOperation("删除")
    @PreAuthorize("@auth.hasUrl()")
    @Log(moduleName = "评论", businessType = BusinessType.DELETE)
    public ResponseResult delete(@PathVariable Long[] ids) {
        navCommentService.removeByIds(Arrays.asList(ids));
        return ResponseResult.success();
    }

}
