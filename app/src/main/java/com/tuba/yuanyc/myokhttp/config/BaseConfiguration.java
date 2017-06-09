package com.tuba.yuanyc.myokhttp.config;

/**
 * Author ：yuanyc
 * Time ：2017/6/9
 * Description ：
 */
class BaseConfiguration implements Configuration {
    protected ConnectionConfiguration connectionConfiguration;
    protected RequestConfiguration requestConfiguration;

    @Override
    public ConnectionConfiguration getConnectionConfig() {
        return null;
    }

    @Override
    public RequestConfiguration getRequestConfig() {
        return null;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        BaseConfiguration that = (BaseConfiguration) o;

        if (connectionConfiguration != null ? !connectionConfiguration.equals(that.connectionConfiguration) : that.connectionConfiguration != null) {
            return false;
        }
        return requestConfiguration != null ? requestConfiguration.equals(that.requestConfiguration) : that.requestConfiguration == null;

    }

    @Override
    public int hashCode() {
        int result = connectionConfiguration != null ? connectionConfiguration.hashCode() : 0;
        result = 31 * result + (requestConfiguration != null ? requestConfiguration.hashCode() : 0);
        return result;
    }
}
