package com.tuba.yuanyc.myokhttp.config;


import com.tuba.yuanyc.myokhttp.http.HttpMethod;

import java.util.HashMap;
import java.util.Map;

/**
 * Author ：yuanyc
 * Time ：2017/6/9
 * Description ：
 */

public class RequestConfiguration {

    private HttpMethod method = HttpMethod.POST;
    private HashMap<String, String> params;
    private HashMap<String, String> headers;

    public RequestConfiguration() {

        params = new HashMap<>();
        headers = new HashMap<>();
    }

    public HttpMethod getMethod() {
        return method;
    }

    public void setMethod(HttpMethod method) {
        this.method = method;
    }

    public Map<String, String> getParams() {
        return params;
    }

    public void setParams(HashMap<String, String> params) {
        this.params = params;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public void setHeaders(HashMap<String, String> headers) {
        this.headers = headers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        RequestConfiguration that = (RequestConfiguration) o;

        if (method != that.method) {
            return false;
        }
        if (params != null ? !params.equals(that.params) : that.params != null) {
            return false;
        }
        return headers != null ? headers.equals(that.headers) : that.headers == null;

    }

    @Override
    public int hashCode() {
        int result = method != null ? method.hashCode() : 0;
        result = 31 * result + (params != null ? params.hashCode() : 0);
        result = 31 * result + (headers != null ? headers.hashCode() : 0);
        return result;
    }
}
