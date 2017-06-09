package com.tuba.yuanyc.myokhttp.Utils;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Author ：yuanyc
 * Time ：2017/6/9
 * Description ：暂且使用java提供的线程池构造器
 */

public class GlobalThreadManager {
    private ExecutorService executorService = Executors.newCachedThreadPool();

    /**
     * 禁止构造
     */
    private GlobalThreadManager() {
    }

    /**
     * 获得单例
     *
     * @return
     */
    public static GlobalThreadManager getInstance() {
        return InstanceHolder.INSTANCE;
    }

    public void execute(Runnable runnable) {
        executorService.execute(runnable);
    }

    /**
     * 单例持有器
     */
    private static final class InstanceHolder {
        private static final GlobalThreadManager INSTANCE = new GlobalThreadManager();
    }
}
