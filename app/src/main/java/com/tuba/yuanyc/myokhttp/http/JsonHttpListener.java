package com.tuba.yuanyc.myokhttp.http;

/**
 * Author ：yuanyc
 * Time ：2017/6/9
 * Description ：
 */

public abstract class JsonHttpListener extends DefaultHttpListener<JsonResponse>{
    @Override
    protected JsonResponse createHttpResponse(HttpResponse response) {
        return new JsonResponse(response);
    }

    @Override
    protected void doResponse(JsonResponse response) {

    }
}
