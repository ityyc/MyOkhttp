package com.tuba.yuanyc.myokhttp.http;

import com.tuba.yuanyc.myokhttp.config.Configuration;
import com.tuba.yuanyc.myokhttp.config.RequestConfiguration;

import java.util.HashMap;
import java.util.Map;

import okhttp3.FormBody;
import okhttp3.HttpUrl;
import okhttp3.Request;

/**
 * Author ：yuanyc
 * Time ：2017/6/9
 * Description ：
 */

public class HttpRequestImp implements HttpRequest {
    /**
     * 默认get请求
     */
    private HttpMethod method = HttpMethod.GET;
    private String url;
    private HashMap<String, String> params;
    private HashMap<String, String> headers;
    private Configuration configuration;

    public HttpRequestImp() {
    }

    @Override
    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public void setMethod(HttpMethod method) {
        this.method = method;
    }

    @Override
    public void putParam(String key, String value) {
        if (this.params == null) {
            this.params = new HashMap<>();
        }
        this.params.put(key, value);
    }

    @Override
    public void putHeader(String key, String value) {
        if (this.headers == null) {
            this.headers = new HashMap<>();
        }
        this.headers.put(key, value);
    }

    @Override
    public void setConfiguration(Configuration configuration) {
        this.configuration = configuration;
    }

    @Override
    public Configuration getConfiguration() {
        return this.configuration;
    }

    @Override
    public String getUrl() {
        return url;
    }

    @Override
    public HttpMethod getMethod() {
        return method;
    }

    @Override
    public Map<String, String> getHeaders() {
        if (this.headers == null) {
            this.headers = new HashMap<>();
        }
        return headers;
    }

    @Override
    public Map<String, String> getParams() {
        if (this.params == null) {
            this.params = new HashMap<>();
        }
        return params;
    }

    Request buildOKHttpRequest(Configuration config) {
        Request.Builder builder = new Request.Builder();
        RequestConfiguration requestConfig = config.getRequestConfig();
        HttpMethod httpMethod = requestConfig.getMethod();
        // headers
        buildHeader(builder, config);
        Map<String, String> retMap;
        switch (httpMethod) {
            case GET:
                HttpUrl httpUrl = HttpUrl.parse(url);
                retMap = mergeMap(params, config.getRequestConfig().getParams());
                if (!retMap.isEmpty()) {
                    HttpUrl.Builder urlBuilder = httpUrl.newBuilder();
                    for (Map.Entry<String, String> item : retMap.entrySet()) {
                        urlBuilder.addEncodedQueryParameter(item.getKey(), item.getValue());
                    }
                    httpUrl = urlBuilder.build();
                }
                builder.url(httpUrl).get();
                break;
            case POST:
                builder.url(url);
                //merge params
                retMap = mergeMap(params, config.getRequestConfig().getParams());
                FormBody.Builder bodyBuilder = new FormBody.Builder();
                if (!retMap.isEmpty()) {
                    for (Map.Entry<String, String> item : retMap.entrySet()) {
                        bodyBuilder.addEncoded(item.getKey(), item.getValue());
                    }
                }

                builder.post(bodyBuilder.build());
                break;
        }


        Request okHttpRequest = builder.build();
        return okHttpRequest;
    }

    //合并请求头参数
    private void buildHeader(Request.Builder builder, Configuration config) {
        if (headers != null || (config != null)) {
            RequestConfiguration requestConfiguration = config.getRequestConfig();
            Map<String, String> changeHeaders = null;
            if (requestConfiguration != null) {
                changeHeaders = requestConfiguration.getHeaders();
            }
            Map<String, String> retMap = mergeMap(headers, changeHeaders);

            for (Map.Entry<String, String> item : retMap.entrySet()) {
                builder.addHeader(item.getKey(), item.getValue());
            }
        }
    }


    private Map<String, String> mergeMap(Map<String, String> first, Map<String, String> second) {
        HashMap<String, String> retMap = new HashMap<>();
        if (first != null && !first.isEmpty()) {
            retMap.putAll(first);
        }
        if (second != null && !second.isEmpty()) {
            retMap.putAll(second);
        }
        return retMap;
    }
}
