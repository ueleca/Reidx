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

package com.uele.reidx.android.ui.fragments.tabEmails;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.view.View;

import com.uele.reidx.android.ui.activities.leads.LeadsActivity;
import com.uele.reidx.android.ui.base.BaseFragment;

import javax.inject.Inject;

public class TabEmailsFragment
        extends BaseFragment implements TabEmailsView {

    private LeadsActivity mLeadsProfileActivity;

    @Inject
    protected TabEmailsPresenter mTabEmailsPresenter;

    public static TabEmailsFragment newInstance() {
        return new TabEmailsFragment();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

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
