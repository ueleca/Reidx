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

package com.uele.reidx.android.ui.activities.splash;

import android.content.Context;

import com.uele.reidx.android.data.network.ApiHelper;
import com.uele.reidx.android.data.prefs.PreferencesHelper;
import com.uele.reidx.android.di.qualifier.ApplicationContext;
import com.uele.reidx.android.ui.base.BaseInteractor;

import javax.inject.Inject;

public class SplashInteractor
        extends BaseInteractor implements SplashReidxInteractor {

    private Context mContext;

    @Inject
    public SplashInteractor(@ApplicationContext Context context,
                            PreferencesHelper preferencesHelper,
                            ApiHelper apiHelper) {

        super(preferencesHelper, apiHelper);
        mContext = context;
    }

        @Override
    public int getCurrentUserLoggedInMode() {
        return getPreferencesHelper().getCurrentUserLoggedInMode();
    }
}
