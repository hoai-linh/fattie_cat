package com.example.twinklestar.fatiecat.data.api;


import com.example.twinklestar.fatiecat.data.entity.AccessToken;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface PlatformAPI {
    @POST("v1/auth/token")
    @FormUrlEncoded
    Call<AccessToken> getAccessToken(@Field("auth_code") String authCode, @Field("client_id") String clientId);

}
