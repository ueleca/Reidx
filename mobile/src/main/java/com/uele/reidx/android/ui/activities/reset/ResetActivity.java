/*
 * Copyright 2016 Brian Donaldson
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

package com.uele.reidx.android.ui.activities.reset;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.uele.reidx.android.R;
import com.uele.reidx.android.ui.activities.login.LoginActivity;
import com.uele.reidx.android.ui.base.BaseActivity;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ResetActivity
        extends BaseActivity implements ResetReidxView {

    @BindView(R.id.resetPasswordBtn) Button btnResetPassword;
    @BindView(R.id.resetBackBtn) Button btnBack;

    @Inject
    ResetReidxPresenter<ResetReidxView> mResetPresenter;

    public static Intent getStartIntent(Context context) {
        Intent intent = new Intent(context, ResetActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset);
        getActivityComponent().inject(this);
        setUnBinder(ButterKnife.bind(this));
        mResetPresenter.onAttach(ResetActivity.this);
    }

    @Override
    protected void onDestroy() {
        mResetPresenter.onDetach();
        super.onDestroy();
    }

    @Override
    protected void setUp() {

    }

    @Override
    public void startLoginActivity() {
        startActivity(new Intent(ResetActivity.this, LoginActivity.class));
        finish();
    }

    @OnClick(R.id.resetPasswordBtn)
    @Override
    public void onResetClicked(){

    }

    @OnClick(R.id.resetBackBtn)
    @Override
    public void onBackClicked(){

    }
}
