package com.tuba.yuanyc.myokhttp.config;

import java.util.HashMap;

/**
 * Author ：yuanyc
 * Time ：2017/6/9
 * Description ：
 */

public class ConfigurationConst {

    private static HashMap<String, Configuration> configurationHashMap = new HashMap<>();

    static {
        configurationHashMap.put("default", new DefaultConfiguration());
        configurationHashMap.put("urlRule", new UrlRuleConfiguration());

    }

    public static Configuration DEFAULT_CONFIGURATION = configurationHashMap.get("default");
    public static Configuration ULR_RULE_CONFIGURATION = configurationHashMap.get("default");
}
