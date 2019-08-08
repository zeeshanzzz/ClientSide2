package com.softec.clientside.networkRequest;

import android.app.Activity;

import com.softec.clientside.model.models.ResponseFromServer;
import com.softec.clientside.networkRequest.retrofitBuilder.RetrofitClient;
import com.softec.clientside.networkRequest.retrofitBuilder.sendLoginData;
import com.softec.clientside.views.login.presenter.callback.LoginCallback;


import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NetworkRequest {

    public void loginRequest(Activity activity, final LoginCallback loginCallback, String email, String password){
        HashMap<String, String> params = new HashMap<String, String>();
        params.put("user_id", email);
        params.put("user_pwd", password);
        sendLoginData sendLoginData = RetrofitClient.getRetrofitInstance().create(sendLoginData.class);
        Call<ResponseFromServer> responseFromServerCall = sendLoginData.getLoginData(params);
        responseFromServerCall.enqueue(new Callback<ResponseFromServer>() {
            @Override
            public void onResponse(Call<ResponseFromServer> call, Response<ResponseFromServer> response) {
              loginCallback.onSuccess(response);

            }

            @Override
            public void onFailure(Call<ResponseFromServer> call, Throwable t) {
             loginCallback.onError(t);
            }
        });

    }
}
