package com.incarcloud.common.data;

/**
 * 请求响应数据失败状态码（公共部分）
 *
 * @author Aaric, created on 2020-04-06T20:04.
 * @version 0.4.1-SNAPSHOT
 */
public interface ResponseFailureState {

    /**
     * 0001 - 0999: 定义系统错误码
     */
    // 未知错误
    String ERROR_0001 = "0001";

    // 非法请求
    String ERROR_0002 = "0002";

    // 系统繁忙，请稍候重试
    String ERROR_0003 = "0003";

    // 数据校验失败
    String ERROR_0004 = "0004";
}
