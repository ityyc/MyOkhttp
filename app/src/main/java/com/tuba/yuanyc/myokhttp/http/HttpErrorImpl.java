package com.tuba.yuanyc.myokhttp.http;

/**
 * Author ：yuanyc
 * Time ：2017/6/9
 * Description ：HttpError异常错误的实现类
 */

public class HttpErrorImpl implements HttpError{
    private Handle handle;
    private Throwable throwable;

    public HttpErrorImpl(Handle handle, Throwable throwable) {
        this.handle = handle;
        this.throwable = throwable;
    }

    @Override
    public Handle getHandle() {
        return handle;
    }

    @Override
    public Throwable getThrowable() {
        return throwable;
    }
}
