package com.zhaoxi.admin.nav.comment.mapstruct;

import com.zhaoxi.admin.client.nav.dto.ClientNavCommentAddDTO;
import com.zhaoxi.admin.client.nav.vo.ClientNavCommentTreeVO;
import com.zhaoxi.admin.nav.comment.po.NavComment;
import com.zhaoxi.admin.nav.comment.vo.NavCommentVO;
import com.zhaoxi.common.framework.mybatis.page.vo.PageVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 评论对象转换
 *
 * @author zhaoxi
 */
@Mapper
public interface NavCommentConverter {

    NavCommentConverter INSTANCE = Mappers.getMapper(NavCommentConverter.class);

    PageVO<NavCommentVO> convert(PageVO<NavComment> pageVO);

    NavCommentVO convert(NavComment navComment);

    List<ClientNavCommentTreeVO> convertClient(List<NavComment> list);

    NavComment convert(ClientNavCommentAddDTO addDTO);

}