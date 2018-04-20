package com.example.twinklestar.fatiecat.di;

import android.app.Application;
import android.content.Context;

import dagger.Provides;

/**
 * Created by linh on 2018/04/20.
 */

public class ApplicationModule {
    private final Application application;

    public ApplicationModule(Application application) {
        this.application = application;
    }

    @Provides
    @ApplicationScope
    Context provideApplicationContext() {
        return application.getApplicationContext();
    }

}
