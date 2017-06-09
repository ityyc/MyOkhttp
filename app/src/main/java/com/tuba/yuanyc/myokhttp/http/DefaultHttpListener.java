package com.tuba.yuanyc.myokhttp.http;

/**
 * Author ：yuanyc
 * Time ：2017/6/9
 * Description ：
 */

abstract class DefaultHttpListener<T extends DefaultHttpResponse> implements HttpListener {
    @Override
    public void onResponse(HttpResponse response) {
        T httpResponse = createHttpResponse(response);
        try {
            httpResponse.process();
            doResponse(httpResponse);
        } catch (Throwable t) {
            onError(new HttpErrorImpl(httpResponse.getHandle(),t));
        }
    }
    protected abstract T createHttpResponse(HttpResponse response);
    /**
     * 当请求成功并解析成功以后，要做的处理
     *
     * @param response 成功以后返回的数据
     */
    protected abstract void doResponse(T response);
}
