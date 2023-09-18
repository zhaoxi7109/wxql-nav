package com.zhaoxi.admin.system.log.operation.service;

import com.zhaoxi.admin.system.log.operation.dto.LogOperationPageDTO;
import com.zhaoxi.admin.system.log.operation.po.LogOperation;
import com.zhaoxi.admin.system.log.operation.vo.LogOperationVo;
import com.zhaoxi.common.framework.mybatis.page.vo.PageVO;
import com.zhaoxi.common.framework.web.service.BaseService;

/**
 * 操作日志
 *
 * @author zhaoxi
 * @date 2022/7/5
 */
public interface LogOperationService extends BaseService<LogOperation> {

    /**
     * 分页列表
     */
    PageVO<LogOperationVo> pageList(LogOperationPageDTO pageDTO);

    /**
     * 获取详情
     */
    LogOperationVo getLogOperationById(Long id);
}
