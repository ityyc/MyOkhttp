package com.tuba.yuanyc.myokhttp.config;

/**
 * Author ：yuanyc
 * Time ：2017/6/9
 * Description ：网络请求的配置信息
 */

public interface Configuration {
    ConnectionConfiguration getConnectionConfig();

    RequestConfiguration getRequestConfig();


}
