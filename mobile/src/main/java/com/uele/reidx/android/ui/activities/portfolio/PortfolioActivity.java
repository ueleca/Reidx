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

package com.uele.reidx.android.ui.activities.portfolio;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.uele.reidx.android.R;
import com.uele.reidx.android.ui.base.BaseActivity;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PortfolioActivity
        extends BaseActivity implements PortfolioReidxView {

    @BindView(R.id.app_bar)
    Toolbar mToolbar;

    @Inject
    PortfolioReidxPresenter<PortfolioReidxView> mPortfolioPresenter;

    public static Intent getStartIntent(Context context) {
        Intent intent = new Intent(context, PortfolioActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        getActivityComponent().inject(this);
        setUnBinder(ButterKnife.bind(this));
        mPortfolioPresenter.onAttach(PortfolioActivity.this);
    }

    @Override
    protected void onDestroy() {
        mPortfolioPresenter.onDetach();
        super.onDestroy();
    }

    @Override
    protected void setUp() {

    }
}