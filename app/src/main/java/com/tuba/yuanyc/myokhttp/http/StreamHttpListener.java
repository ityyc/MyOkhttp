package com.tuba.yuanyc.myokhttp.http;

/**
 * Author ：yuanyc
 * Time ：2017/6/9
 * Description ：
 */

public abstract class  StreamHttpListener extends DefaultHttpListener<StreamResponse>{
    @Override
    protected StreamResponse createHttpResponse(HttpResponse response) {
        return new StreamResponse(response);
    }
}
