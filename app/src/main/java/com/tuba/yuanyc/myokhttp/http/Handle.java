package com.tuba.yuanyc.myokhttp.http;

import okhttp3.Call;

/**
 * Author ：yuanyc
 * Time ：2017/6/9
 * Description ：句柄类，用于封装取消请求操作
 */

public class Handle {
    private Call call;
    /**
     * 请求取消操作的标识符
     */
    private boolean canceled = false;

    /**
     * 构造方法
     */
    public Handle() {

    }

    /**
     * 取消操作（存在多线程访问）
     * 调用此方法之前先调用{@link #isCanceled()}此方法判断一下是否可以执行取消操作
     */
    public void cancel() {
        if (null == call) {
            synchronized (this) {
                if (null == call) {
                    canceled = true;
                    return;
                }
            }
        }
        call.cancel();
    }

    /**
     * 设置call（存在多线程访问）
     * @param call
     */
    public void setCall(Call call) {
        this.call = call;
        synchronized (this) {
            //如果标识为true，则先执行取消操作
            if (canceled) {
                call.cancel();
            }
        }
    }

    /**
     * 请求是否已经取消
     * <p>true:已经取消操作</p>
     * <p>false:未取消操作</p>
     *
     * @return
     */
    public boolean isCanceled() {
        return null != call ? call.isCanceled() : canceled;
    }


}
