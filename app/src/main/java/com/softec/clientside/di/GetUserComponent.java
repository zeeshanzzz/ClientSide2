package com.softec.clientside.di;

import com.softec.clientside.views.login.presenter.LoginPresenter;
import com.softec.clientside.views.login.view.LoginActivity;

import dagger.Component;

@Component(modules = PresenterModules.class)
public interface GetUserComponent {
 void inject(LoginActivity loginActivity);
}
