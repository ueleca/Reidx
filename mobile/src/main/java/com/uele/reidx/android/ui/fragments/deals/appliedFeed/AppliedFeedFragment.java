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

package com.uele.reidx.android.ui.fragments.deals.appliedFeed;

import android.os.Bundle;
import android.support.annotation.StringRes;
import android.view.View;

import com.uele.reidx.android.ui.base.BaseFragment;

import javax.inject.Inject;

public class AppliedFeedFragment
        extends BaseFragment implements AppliedFeedReidxView {

    private static final String TAG = "AppliedFeedFragment";

    @Inject
    AppliedFeedReidxPresenter<AppliedFeedReidxView> mAppliedFeedPresenter;

    public static AppliedFeedFragment newInstance() {
        Bundle args = new Bundle();
        AppliedFeedFragment fragment = new AppliedFeedFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected void setUp(View view) {

    }

    @Override
    public void showMessage(String message) {

    }

    @Override
    public void showMessage(@StringRes int resId) {

    }

    @Override
    public void showOfflineMessage(boolean isCritical) {

    }

    @Override
    public void showErrorMessage(Throwable throwable) {

    }
}
