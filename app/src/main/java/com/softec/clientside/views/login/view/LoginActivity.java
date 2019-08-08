package com.softec.clientside.views.login.view;

import android.os.Bundle;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import com.google.android.material.textfield.TextInputLayout;
import com.softec.clientside.R;
import com.softec.clientside.di.GetUserComponent;
import com.softec.clientside.di.PresenterModules;
import com.softec.clientside.databinding.ActivityLoginBinding;
import com.softec.clientside.model.models.User;
import com.softec.clientside.views.login.presenter.LoginPresenter;

import java.util.Objects;

import javax.inject.Inject;

public class LoginActivity extends AppCompatActivity implements View {

    public LoginPresenter loginActivityPresenter;
    private ActivityLoginBinding activityLoginBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityLoginBinding = DataBindingUtil.setContentView(this, R.layout.activity_login);
        User user = new User();

//        GetUserComponent getUserComponent = DaggerGetUserComponent.builder().presenterModules(new PresenterModules(this, user)).build();
//        LoginPresenter loginPresenter = getUserComponent.inject(this);
//        loginClickListener();
    }

    private void loginClickListener() {
        activityLoginBinding.btnLogin.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(android.view.View v) {
                loginActivityPresenter.setEmail(getEmail());
                loginActivityPresenter.setPassword(getPassword());
                loginActivityPresenter.loginRequest();
            }
        });
    }

    @Override
    public String getEmail() {
        return getInputText(activityLoginBinding.edtEmail);
    }

    @Override
    public String getPassword() {
        return getInputText(activityLoginBinding.edtPassword);
    }

    @Override
    public void showMessge(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    private String getInputText(TextInputLayout inputLayout) {
        return Objects.requireNonNull(inputLayout.getEditText()).getText().toString();
    }
}
