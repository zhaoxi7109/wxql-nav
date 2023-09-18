package com.zhaoxi.admin.client.nav.controller;

import com.zhaoxi.admin.client.nav.dto.ClientNavCommentAddDTO;
import com.zhaoxi.admin.client.nav.vo.ClientNavCommentTreeVO;
import com.zhaoxi.admin.nav.comment.service.NavCommentService;
import com.zhaoxi.common.core.web.response.ResponseResult;
import com.zhaoxi.common.rate.limiter.annotation.RateLimiter;
import com.zhaoxi.common.rate.limiter.enums.RateLimiterType;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * 客户端评论
 *
 * @author zhaoxi
 */
@Api(tags = "客户端评论")
@RestController
@RequestMapping("/client/nav/comment")
public class ClientNavCommentController {

    @Autowired
    private NavCommentService navCommentService;

    @ApiOperation("开启状态")
    @GetMapping("/getOpenStatus")
    public ResponseResult<Boolean> getOpenStatus() {
        return ResponseResult.success(navCommentService.getOpenStatus());
    }

    @ApiOperation("树形列表")
    @GetMapping("/tree")
    public ResponseResult<List<ClientNavCommentTreeVO>> tree() {
        List<ClientNavCommentTreeVO> list = navCommentService.treeClient();
        return ResponseResult.success(list);
    }

    @ApiOperation("提交评论")
    @PostMapping
    @RateLimiter(type = RateLimiterType.IP, count = 1)
    public ResponseResult add(@Valid @RequestBody ClientNavCommentAddDTO addDTO) {
        navCommentService.add(addDTO);
        return ResponseResult.success();
    }

}
