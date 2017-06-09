package com.tuba.yuanyc.myokhttp.config;

/**
 * Author ：yuanyc
 * Time ：2017/6/9
 * Description ：
 */

class DefaultConfiguration extends BaseConfiguration {

    @Override
    public ConnectionConfiguration getConnectionConfig() {
        if (connectionConfiguration == null) {
            connectionConfiguration = new ConnectionConfiguration();
            connectionConfiguration.setConnectionTimeOut(60 * 1000);
            connectionConfiguration.setWriteTimeOut(60 * 1000);
            connectionConfiguration.setReadTimeOut(60 * 1000);
        }
        return connectionConfiguration;

    }

    @Override
    public RequestConfiguration getRequestConfig() {
        if (requestConfiguration == null) {
            requestConfiguration = new RequestConfiguration();
        }
        return requestConfiguration;
    }
}
