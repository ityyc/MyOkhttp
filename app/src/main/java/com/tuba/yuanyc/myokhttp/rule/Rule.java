package com.tuba.yuanyc.myokhttp.rule;


import com.tuba.yuanyc.myokhttp.config.Configuration;
import com.tuba.yuanyc.myokhttp.http.HttpRequest;

/**
 * Author ：yuanyc
 * Time ：2017/6/9
 * Description ：
 */

public interface Rule {

    Configuration getConfiguration(HttpRequest request);
}
