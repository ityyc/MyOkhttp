package com.tuba.yuanyc.myokhttp.http;

/**
 * Author ：yuanyc
 * Time ：2017/6/9
 * Description ：
 */

public interface HttpListener {
    /**
     * 请求回调
     * @param request
     */
    void onRequest(HttpRequest request);

    /**
     * 响应回调
     * @param response
     */
    void onResponse(HttpResponse response);

    /**
     * 异常出错回调
     * @param error
     */
    void onError(HttpError error);
}
