package com.softec.clientside.networkRequest.retrofitBuilder;

import com.softec.clientside.BuildConfig;
import com.softec.clientside.model.models.ResponseFromServer;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

public interface sendLoginData {
    @GET(BuildConfig.EndPoint)
    Call<ResponseFromServer> getLoginData(@QueryMap Map<String, String> params

    );
}
