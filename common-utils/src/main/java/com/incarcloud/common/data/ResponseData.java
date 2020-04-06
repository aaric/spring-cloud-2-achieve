package com.incarcloud.common.data;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * 请求响应数据对象
 *
 * @param <T> 支持Object泛型
 * @author Aaric, created on 2020-04-06T20:03.
 * @version 0.4.1-SNAPSHOT
 */
@Data
@Accessors(chain = true)
@NoArgsConstructor
@ApiModel(description = "响应数据对象")
public final class ResponseData<T extends Object> implements ResponseSuccessState, ResponseFailureState {

    @ApiModelProperty(position = 1, value = "状态码(0000-请求成功，其它异常)")
    private String code;

    @ApiModelProperty(position = 2, value = "附加信息")
    private String message = "SUCCESS";

    @ApiModelProperty(position = 3, value = "数据结果")
    private T data;

    private ResponseData(String code, T data) {
        this.code = code;
        this.data = data;
    }

    @SuppressWarnings("unchecked")
    public static <T extends Object> ResponseData<T> ok() {
        return ok(null);
    }

    @SuppressWarnings("unchecked")
    public static <T extends Object> ResponseData<T> ok(T data) {
        return new ResponseData(DEFAULT_SUCCESS, data);
    }

    @SuppressWarnings("unchecked")
    public static <T extends Object> ResponseData<T> error(String errorCode) {
        return error(errorCode, null);
    }

    @SuppressWarnings("unchecked")
    public static <T extends Object> ResponseData<T> error(String errorCode, T data) {
        return new ResponseData(errorCode, data);
    }

    @SuppressWarnings("unchecked")
    public <T extends Object> ResponseData<T> extraMsg(String msg) {
        this.setMessage(msg);
        return (ResponseData<T>) this;
    }
}
