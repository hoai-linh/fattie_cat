package com.example.twinklestar.fatiecat.application.helper;

import android.content.Context;

import javax.inject.Inject;

/**
 * ResourceString
 * <p>
 * ViewModelなどでリソースを利用するためのもの
 * 単体テスト時のContextへのアクセスの分離をする為でもある
 */
public class ResourceString {

    private Context context; //Context

    @Inject
    public ResourceString(Context context) {
        this.context = context;
    }
}
