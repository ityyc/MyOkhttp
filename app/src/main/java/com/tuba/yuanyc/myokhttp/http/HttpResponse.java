package com.tuba.yuanyc.myokhttp.http;

import java.io.IOException;
import java.io.InputStream;

/**
 * Author ：yuanyc
 * Time ：2017/6/9
 * Description ：
 */

public interface HttpResponse extends BaseHttpResponse{
    /**
     * 获取响应字符串数据
     * @return
     * @throws IOException
     */
    String getString()throws IOException;

    /**
     * 获取响应的字节数据
     * @return
     * @throws IOException
     */
    byte[] getBytes()throws IOException;

    /**
     * 获取响应的流数据
     * @return
     */
    InputStream getInputStream();
}
