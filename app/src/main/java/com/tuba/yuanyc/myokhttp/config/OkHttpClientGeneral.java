package com.tuba.yuanyc.myokhttp.config;

import com.facebook.stetho.okhttp3.StethoInterceptor;

import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;

/**
 * Author ：yuanyc
 * Time ：2017/6/9
 * Description ：
 */

public class OkHttpClientGeneral {

    public static OkHttpClient general(Configuration configuration) {
        ConnectionConfiguration connection = configuration.getConnectionConfig();
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(connection.getConnectionTimeOut(), TimeUnit.MILLISECONDS)//
                .readTimeout(connection.getReadTimeOut(), TimeUnit.MILLISECONDS)//
                .writeTimeout(connection.getWriteTimeOut(), TimeUnit.MILLISECONDS)//
                .addNetworkInterceptor(new StethoInterceptor());
        //add interceptor
        List<Class> clazz = connection.getInterceptors();
        if (clazz == null || clazz.isEmpty()) {
            return builder.build();
        }
        for (Class item : clazz) {
            try {
                Object obj = item.newInstance();
                if (obj instanceof Interceptor) {
                    builder.addInterceptor((Interceptor) obj);
                }
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }


        return builder.build();

    }


}
