package cn.fxbin.bubble.fireworks.web.support;

import cn.fxbin.bubble.fireworks.core.model.Result;
import cn.fxbin.bubble.fireworks.core.model.ResultCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.lang.Nullable;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * BaseController
 *
 * @author fxbin
 * @version v1.0
 * @since 2020/3/30 16:07
 */
@Slf4j
public abstract class BaseController {

    @Resource
    public HttpServletRequest request;

    @Resource
    public HttpServletResponse response;

    /**
     * success
     *
     * @since 2020/3/31 10:59
     * @return cn.fxbin.bubble.fireworks.core.model.Result<T>
     */
    public <T> Result<T> success() {
        return Result.success();
    }

    /**
     * success
     *
     * @since 2020/3/31 10:59
     * @param data 数据
     * @return cn.fxbin.bubble.fireworks.core.model.Result<T>
     */
    public <T> Result<T> success(@Nullable T data) {
        return Result.success(data);
    }

    /**
     * failure
     *
     * @since 2020/3/31 10:59
     * @param errmsg 错误信息
     * @return cn.fxbin.bubble.fireworks.core.model.Result<T>
     */
    public <T> Result<T> failure(String errmsg) {
        return Result.failure(ResultCode.FAILURE, errmsg);
    }

}
