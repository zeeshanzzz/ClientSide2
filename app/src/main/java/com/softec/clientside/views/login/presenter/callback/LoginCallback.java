package com.softec.clientside.views.login.presenter.callback;

import com.softec.clientside.model.models.ResponseFromServer;

import retrofit2.Response;

public interface LoginCallback {
    public void onSuccess(Response<ResponseFromServer> responseFromServerResponse);

    public void onError(Throwable throwable);
}
