package com.tuba.yuanyc.myokhttp.http;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Set;

import okhttp3.Headers;
import okhttp3.Response;

/**
 * Author ：yuanyc
 * Time ：2017/6/9
 * Description ：HttpResponse的实现类
 */

public class HttpResponseImp implements HttpResponse {
    private Handle handle;

    private Response okHttpResponse;

    private HashMap<String, String> headers;

    public HttpResponseImp(Handle handle, Response okHttpResponse) {
        this.handle = handle;
        this.okHttpResponse = okHttpResponse;
    }

    @Override
    public int getCode() {
        return okHttpResponse.code();
    }

    @Override
    public HashMap<String, String> getHeaders() {

        if (null != headers) {
            return headers;
        }
        headers = new HashMap<>();
        Headers okHttpHeaders = okHttpResponse.headers();
        if (okHttpHeaders == null || okHttpHeaders.size() < 0) {
            return headers;
        }
        Set<String> keySet = okHttpHeaders.names();
        for (String key : keySet) {
            headers.put(key, okHttpHeaders.get(key));
        }
        return headers;
    }

    @Override
    public Handle getHandle() {
        return handle;
    }

    @Override
    public String getString() throws IOException {
        return okHttpResponse.body().toString();
    }

    @Override
    public byte[] getBytes() throws IOException {
        return okHttpResponse.body().bytes();
    }

    @Override
    public InputStream getInputStream() {
        return okHttpResponse.body().byteStream();
    }
}
