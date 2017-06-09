package com.tuba.yuanyc.myokhttp.http;

import android.support.annotation.NonNull;

import com.tuba.yuanyc.myokhttp.Utils.GlobalThreadManager;
import com.tuba.yuanyc.myokhttp.config.Configuration;
import com.tuba.yuanyc.myokhttp.config.ConfigurationConst;
import com.tuba.yuanyc.myokhttp.config.OkHttpCache;
import com.tuba.yuanyc.myokhttp.rule.RuleManager;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Response;

/**
 * Author ：yuanyc
 * Time ：2017/6/9
 * Description ：网络请求辅助类
 */

public class HttpRequestHelper {
    private static final OkHttpCache cache = new OkHttpCache();
    private static final RuleManager ruleManager = new RuleManager();

    /**
     * 网络请求的唯一入口
     * @param listener 监听器
     * @return 返回句柄
     */
    public static Handle sendRequest(final HttpListener listener) {
        final Handle handle = new Handle();
        GlobalThreadManager.getInstance().execute(new Runnable() {
            @Override
            public void run() {
                if (handle.isCanceled()) {
                    return;
                }
                HttpRequestImp request = new HttpRequestImp();
                listener.onRequest(request);
                if (handle.isCanceled()) {
                    return;
                }
                Configuration configuration = findConfiguration(request);
                //根据配置信息返回okHttpClient对象
                OkHttpClient okHttpClient = cache.getValue(configuration);
                //调用newCall方法添加请求
                Call call = okHttpClient.newCall(request.buildOKHttpRequest(configuration));
                //设置句柄
                handle.setCall(call);
                //执行请求
                doCall(call);
            }

            private void doCall(Call call) {
                try {
                    Response response = call.execute();
                    listener.onResponse(new HttpResponseImp(handle, response));
                } catch (Throwable throwable) {
                    listener.onError(new HttpErrorImpl(handle, throwable));
                }
            }

        });
        return handle;
    }

    @NonNull
    private static Configuration findConfiguration(HttpRequestImp request) {
        Configuration configuration = request.getConfiguration();
        if (configuration == null) {
            configuration = ruleManager.getConfiguration(request);
        }
        if (configuration == null) {
            configuration = ConfigurationConst.DEFAULT_CONFIGURATION;
        }
        return configuration;
    }
}
