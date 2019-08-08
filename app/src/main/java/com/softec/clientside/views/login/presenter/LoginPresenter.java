package com.softec.clientside.views.login.presenter;

import android.app.Activity;

import com.softec.clientside.model.models.ResponseFromServer;
import com.softec.clientside.model.models.User;
import com.softec.clientside.networkRequest.NetworkRequest;
import com.softec.clientside.views.login.presenter.callback.LoginCallback;
import com.softec.clientside.views.login.view.View;

import javax.inject.Inject;

import retrofit2.Response;

public class LoginPresenter implements LoginCallback {
    private User user;
    private View view;
    @Inject
    public LoginPresenter(View view,User user) {
        this.view = view;
       this.user = user;
    }

    public LoginPresenter(View view) {
        this.view = view;
    }

    public void setEmail(String email) {
        user.setUserEmail(email);
    }

    public void setPassword(String password) {
        user.setPassword(password);
    }

    public void loginRequest() {
        new NetworkRequest().loginRequest((Activity) view, this, user.getUserEmail(), user.getPassword());
    }

    @Override
    public void onSuccess(Response<ResponseFromServer> responseFromServerResponse) {
        ResponseFromServer responseFromServer = responseFromServerResponse.body();
        view.showMessge(String.valueOf(responseFromServer != null ? responseFromServer.getSuccess() : ""));
    }

    @Override
    public void onError(Throwable throwable) {
        throwable.getMessage();
    }
}

