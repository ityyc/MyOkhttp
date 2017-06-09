package com.tuba.yuanyc.myokhttp.http;

/**
 * Author ：yuanyc
 * Time ：2017/6/9
 * Description ：
 */

public interface HttpError {
    Handle getHandle();
    Throwable getThrowable();
}
