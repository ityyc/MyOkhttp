package com.tuba.yuanyc.myokhttp.rule;


import com.tuba.yuanyc.myokhttp.config.Configuration;
import com.tuba.yuanyc.myokhttp.http.HttpRequest;

import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Author ：yuanyc
 * Time ：2017/6/9
 * Description ：
 */

public class RuleManager {

    private final static CopyOnWriteArrayList<Rule> rules = new CopyOnWriteArrayList<>();

    public RuleManager() {

    }

    public void addRule(Rule rule) {
        if (rule != null && !rules.contains(rule)) {
            rules.add(rule);
        }
    }

    public Configuration getConfiguration(HttpRequest request) {
        Configuration returnConfigure = null;
        Configuration configuration;
        for (Rule rule : rules) {
            configuration = rule.getConfiguration(request);
            if (configuration != null) {
                returnConfigure = configuration;
                break;
            }
        }

        return returnConfigure;
    }
}
