package com.tuba.yuanyc.myokhttp.config;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Author ：yuanyc
 * Time ：2017/6/9
 * Description ：
 */
public class ConnectionConfiguration {
    private long readTimeOut = TimeUnit.MILLISECONDS.convert(10, TimeUnit.SECONDS);
    private long writeTimeOut = TimeUnit.MILLISECONDS.convert(10, TimeUnit.SECONDS);
    private long connectionTimeOut = TimeUnit.MILLISECONDS.convert(10, TimeUnit.SECONDS);
    private List<Class> interceptors = new ArrayList<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        ConnectionConfiguration that = (ConnectionConfiguration) o;

        if (readTimeOut != that.readTimeOut) {
            return false;
        }
        if (writeTimeOut != that.writeTimeOut) {
            return false;
        }
        return connectionTimeOut == that.connectionTimeOut;

    }

    @Override
    public int hashCode() {
        int result = (int) (readTimeOut ^ (readTimeOut >>> 32));
        result = 31 * result + (int) (writeTimeOut ^ (writeTimeOut >>> 32));
        result = 31 * result + (int) (connectionTimeOut ^ (connectionTimeOut >>> 32));
        return result;
    }

    public long getReadTimeOut() {
        return readTimeOut;
    }

    public void setReadTimeOut(long readTimeOut) {
        this.readTimeOut = readTimeOut;
    }

    public long getWriteTimeOut() {
        return writeTimeOut;
    }

    public void setWriteTimeOut(long writeTimeOut) {
        this.writeTimeOut = writeTimeOut;
    }

    public long getConnectionTimeOut() {
        return connectionTimeOut;
    }

    public void setConnectionTimeOut(long connectionTimeOut) {
        this.connectionTimeOut = connectionTimeOut;
    }


    public void addInterceptor(Class clazz) {
        if (!interceptors.contains(clazz)) {
            interceptors.add(clazz);
        }


    }

    public List<Class> getInterceptors() {
        return interceptors;
    }
}
