package com.tuba.yuanyc.myokhttp.http;

import com.tuba.yuanyc.myokhttp.config.Configuration;

import java.util.Map;

/**
 * Author ：yuanyc
 * Time ：2017/6/9
 * Description ：
 */

public interface HttpRequest {
    /**
     * @param url 设置请求的url
     */
    void setUrl(String url);

    /**
     * @param method 设置请求方式
     */
    void setMethod(HttpMethod method);

    /**
     * 设置请求的参数
     *
     * @param key   请求参数的Key
     * @param value 请求参数的value
     */
    void putParam(String key, String value);

    /**
     * 请求头的信息参数
     *
     * @param key   请求头的Key
     * @param value 请求头的Value
     */
    void putHeader(String key, String value);

    /**
     * 设置网络请求的配置
     *
     * @param configuration
     */
    void setConfiguration(Configuration configuration);

    Configuration getConfiguration();

    /**
     * 得到请求的Url
     *
     * @return
     */
    String getUrl();

    /**
     * 得到请求方式
     *
     * @return
     */
    HttpMethod getMethod();

    /**
     * 得到请求头的信息参数
     *
     * @return
     */
    Map<String, String> getHeaders();

    /**
     * 得到请求的参数
     *
     * @return
     */
    Map<String, String> getParams();
}
