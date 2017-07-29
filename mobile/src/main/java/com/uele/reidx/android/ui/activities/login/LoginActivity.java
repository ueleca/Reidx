/*
 * Copyright (C) 2017 Uele, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.uele.reidx.android.ui.activities.login;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.uele.reidx.android.R;
import com.uele.reidx.android.ui.activities.main.MainActivity;
import com.uele.reidx.android.ui.base.BaseActivity;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity
        extends BaseActivity implements LoginReidxView {

    private static final String TAG = "LoginActivity";

    @Inject
    LoginReidxPresenter<LoginReidxView> mLoginPresenter;

    @BindView(R.id.loginEmailEdt) EditText loginEmailEdt;
    @BindView(R.id.loginPasswordEdt) EditText loginPasswordEdt;
    @BindView(R.id.loginBtn) Button loginBtn;

    @BindView(R.id.tvForgotPassword) TextView forgotPasswordTextView;

    public static Intent getStartIntent(Context context) {
        Intent intent = new Intent(context, LoginActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getActivityComponent().inject(this);
        setUnBinder(ButterKnife.bind(this));
        mLoginPresenter.onAttach(LoginActivity.this);
    }

    @OnClick(R.id.loginBtn)
    void onServerLoginClick(View v) {
        mLoginPresenter.onServerLoginClick(getEmail(), getPassword());
    }

    @Override
    protected void setUp() {

    }

    @Override
    public void openMainActivity() {
        Intent intent = MainActivity.getStartIntent(LoginActivity.this);
        startActivity(intent);
        finish();
    }

    @Override
    public String getEmail() {
        return loginEmailEdt.getText().toString();
    }

    @Override
    public String getPassword() {
        return loginPasswordEdt.getText().toString();
    }
}

/*
if (!loginPresenter.validate(getUsername(), getPassword())){
        onLoginFailed();
        }
*/