package com.example.twinklestar.fatiecat.usecase.base;

import com.example.twinklestar.fatiecat.usecase.UseCase;

import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import timber.log.Timber;

/**
 * Created by linh on 2018/04/20.
 */

public abstract class SequentialUseCase<PARAM, RESPONSE> extends UseCase {

    private final CompositeDisposable compositeDisposable;
    private UseCaseCallback callback;

    protected SequentialUseCase(Scheduler threadExecutor, Scheduler postExecutionThread) {
        super(threadExecutor, postExecutionThread);
        compositeDisposable = new CompositeDisposable();
    }

    public final void execute(final UseCaseCallback<RESPONSE> callback, PARAM param) {
        Disposable disposable = buildUseCaseSingle(param)
                .subscribeOn(threadExecutor)
                .observeOn(postExecutionThread)
                .subscribe(
                        callback::onSuccess,
                        throwable -> {
                            Timber.e(throwable);
                            this.onThrowable(throwable, callback);
                        }

                        );
        addDisposable(disposable);
    }

    protected abstract Single<RESPONSE> buildUseCaseSingle(PARAM param);

    private void addDisposable(Disposable disposable) {
        compositeDisposable.add(disposable);
    }

    public final void dispose() {
        compositeDisposable.clear();
    }

    protected void onThrowable(Throwable throwable, UseCaseCallback<RESPONSE> callback) {
        callback.onError(throwable);
    }

    public interface UseCaseCallback<RESPONSE> {

        void onSuccess(RESPONSE value);

        void onError(Throwable e);
    }
}
