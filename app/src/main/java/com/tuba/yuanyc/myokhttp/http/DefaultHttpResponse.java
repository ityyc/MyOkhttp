package com.tuba.yuanyc.myokhttp.http;

import java.util.HashMap;

/**
 * Author ：yuanyc
 * Time ：2017/6/9
 * Description ：BaseHttpResponse响应的默认实现类
 */

class DefaultHttpResponse implements BaseHttpResponse{
    protected HttpResponse response;

    DefaultHttpResponse(HttpResponse response) {
        this.response = response;
    }

    @Override
    public int getCode() {
        return response.getCode();
    }

    @Override
    public HashMap<String, String> getHeaders() {
        return response.getHeaders();
    }

    @Override
    public Handle getHandle() {
        return response.getHandle();
    }
    protected void process() throws Throwable {
    }
}
