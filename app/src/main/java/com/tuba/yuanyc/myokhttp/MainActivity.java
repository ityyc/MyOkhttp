package com.tuba.yuanyc.myokhttp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.tuba.yuanyc.myokhttp.http.HttpError;
import com.tuba.yuanyc.myokhttp.http.HttpListener;
import com.tuba.yuanyc.myokhttp.http.HttpRequest;
import com.tuba.yuanyc.myokhttp.http.HttpRequestHelper;
import com.tuba.yuanyc.myokhttp.http.HttpResponse;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //测试使用
        HttpRequestHelper.sendRequest(new HttpListener() {
            @Override
            public void onRequest(HttpRequest request) {

            }

            @Override
            public void onResponse(HttpResponse response) {

            }

            @Override
            public void onError(HttpError error) {

            }
        });
    }
}
