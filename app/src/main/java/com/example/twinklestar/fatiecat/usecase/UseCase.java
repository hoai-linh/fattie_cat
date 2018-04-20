package com.example.twinklestar.fatiecat.usecase;

import io.reactivex.Scheduler;

/**
 * Created by linh on 2018/04/20.
 */

public abstract class UseCase {
    protected Scheduler threadExecutor;
    protected Scheduler postExecutionThread;

    protected UseCase(Scheduler threadExecutor,
                      Scheduler postExecutionThread) {
        this.threadExecutor = threadExecutor;
        this.postExecutionThread = postExecutionThread;
    }
}
