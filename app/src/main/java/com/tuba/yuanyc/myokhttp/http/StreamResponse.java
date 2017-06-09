package com.tuba.yuanyc.myokhttp.http;

import java.io.InputStream;

/**
 * Author ：yuanyc
 * Time ：2017/6/9
 * Description ：
 */

public class StreamResponse extends DefaultHttpResponse {
    StreamResponse(HttpResponse response) {
        super(response);
    }

    /**
     * 获取返回的流数据
     *
     * @return
     */
    public InputStream getInputStream() {
        return response.getInputStream();
    }
}
