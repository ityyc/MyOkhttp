package com.tuba.yuanyc.myokhttp.rule;


import com.tuba.yuanyc.myokhttp.config.Configuration;
import com.tuba.yuanyc.myokhttp.config.ConfigurationConst;
import com.tuba.yuanyc.myokhttp.http.HttpRequest;

import java.util.List;

/**
 * Author ：yuanyc
 * Time ：2017/6/9
 * Description ：根据Url得到一个配置
 */
public class UrlRule implements Rule {

    private List<String> urls;


    public UrlRule(List<String> urls) {
        this.urls = urls;
    }

    @Override
    public Configuration getConfiguration(HttpRequest request) {
        String url = request.getUrl();
        int size = urls.size();
        for (int i = 0; i < size; i++) {
            if (url.toLowerCase().startsWith(urls.get(i).toLowerCase())) {
                return ConfigurationConst.ULR_RULE_CONFIGURATION;
            }
        }
        return null;
    }


}
