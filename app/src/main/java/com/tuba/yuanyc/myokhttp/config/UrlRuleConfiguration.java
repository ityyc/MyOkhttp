package com.tuba.yuanyc.myokhttp.config;

/**
 * Author ：yuanyc
 * Time ：2017/6/9
 * Description ：
 */

class UrlRuleConfiguration extends BaseConfiguration {
    @Override
    public ConnectionConfiguration getConnectionConfig() {
        if (connectionConfiguration == null) {
            connectionConfiguration = new ConnectionConfiguration();
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
