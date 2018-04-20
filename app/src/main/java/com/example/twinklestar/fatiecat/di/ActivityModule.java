package com.example.twinklestar.fatiecat.di;

import android.support.v7.app.AppCompatActivity;

import com.example.twinklestar.fatiecat.application.helper.ResourceString;

import dagger.Module;
import dagger.Provides;

/**
 * Created by linh on 2018/04/20.
 */
@Module
public class ActivityModule {
    final AppCompatActivity activity;

    public ActivityModule(AppCompatActivity activity) {
        this.activity = activity;
    }

    @Provides
    public AppCompatActivity activity() {
        return activity;
    }

    @Provides
    public ResourceString resourceString() {
        return new ResourceString(activity);
    }
}
