package com.softec.clientside.di;

import com.softec.clientside.model.models.User;
import com.softec.clientside.views.login.view.View;

import dagger.Module;
import dagger.Provides;

@Module
public class PresenterModules {
    private View view;
    private User user;

    public PresenterModules(View view, User user) {
        this.view = view;
        this.user = user;
    }

    @Provides
    View providePresenterView() {
        return view;
    }

    @Provides
    User provideUser() {
        return user;
    }
}

