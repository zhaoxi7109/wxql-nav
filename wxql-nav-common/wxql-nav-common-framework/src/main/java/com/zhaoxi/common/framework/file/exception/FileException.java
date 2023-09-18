package com.zhaoxi.common.framework.file.exception;

import com.zhaoxi.common.core.constant.HttpStatus;
import com.zhaoxi.common.core.exception.BaseException;

/**
 * 文件异常
 *
 * @author zhaoxi
 * @date 2022/8/25
 */
public class FileException extends BaseException {

    private static final long serialVersionUID = 1L;

    public FileException(String message) {
        super(HttpStatus.FAIL, message, "file");
    }
}
