package com.tuba.yuanyc.myokhttp.config;

import android.support.v4.util.LruCache;


import okhttp3.OkHttpClient;

/**
 * Author ：yuanyc
 * Time ：2017/6/9
 * Description ：
 */

public class OkHttpCache {
    private final static int MAX_CACHE_SIZE = 10;
    private LruCache<ConnectionConfiguration, OkHttpClient> clientLruCache = new LruCache<>(MAX_CACHE_SIZE);


    public OkHttpClient getValue(Configuration configuration) {
        if (configuration == null) {
            return null;
        }
        ConnectionConfiguration connectionConfiguration = configuration.getConnectionConfig();
        OkHttpClient client = clientLruCache.get(connectionConfiguration);
        if (client == null) {
            synchronized (clientLruCache) {
                client = OkHttpClientGeneral.general(configuration);
                clientLruCache.put(connectionConfiguration, client);
            }
        }
        return client;
    }


}
