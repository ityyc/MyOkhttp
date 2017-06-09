package com.tuba.yuanyc.myokhttp.http;

import java.util.HashMap;

/**
 * Author ：yuanyc
 * Time ：2017/6/9
 * Description ：
 */

public interface BaseHttpResponse {
    /**
     * 获取http响应码
     * @return
     */
    int getCode();

    /**
     * 获取响应头信息
     * @return
     */
    HashMap<String,String> getHeaders();

    /**
     * 获取控制句柄
     * @return
     */
    Handle getHandle();
}
