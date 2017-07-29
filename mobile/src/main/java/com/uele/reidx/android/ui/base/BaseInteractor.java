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

package com.uele.reidx.android.ui.base;

import com.uele.reidx.android.data.network.ApiHelper;
import com.uele.reidx.android.data.prefs.PreferencesHelper;
import com.uele.reidx.android.utils.AppConstants;

import javax.inject.Inject;

public class BaseInteractor
        implements ReidxInteractor {

    private final PreferencesHelper mPreferencesHelper;
    private final ApiHelper mApiHelper;

    @Inject
    public BaseInteractor(PreferencesHelper preferencesHelper,
                          ApiHelper apiHelper) {
        mPreferencesHelper = preferencesHelper;
        mApiHelper = apiHelper;
    }

    @Override
    public ApiHelper getApiHelper() {
        return mApiHelper;
    }

    @Override
    public PreferencesHelper getPreferencesHelper() {
        return mPreferencesHelper;
    }

    @Override
    public void setUserAsLoggedOut() {

        updateUserInfo(
                null,
                null,
                AppConstants.LoggedInMode.LOGGED_IN_MODE_LOGGED_OUT,
                null,
                null,
                null);

    }

    @Override
    public void setAccessToken(String accessToken) {
        getPreferencesHelper().setAccessToken(accessToken);

        getApiHelper().getApiHeader()
                .getProtectedApiHeader()
                .setAccessToken(accessToken);
    }

    @Override
    public void updateUserInfo(String accessToken,
                               Long userId,
                               AppConstants.LoggedInMode loggedInMode,
                               String userName,
                               String email,
                               String profilePicPath) {

        getPreferencesHelper().setAccessToken(accessToken);
        getPreferencesHelper().setCurrentUserId(userId);
        getPreferencesHelper().setCurrentUserLoggedInMode(loggedInMode);
        getPreferencesHelper().setCurrentUserName(userName);
        getPreferencesHelper().setCurrentUserEmail(email);
        getPreferencesHelper().setCurrentUserProfilePicUrl(profilePicPath);

        updateApiHeader(userId, accessToken);
    }

    @Override
    public void updateApiHeader(Long userId, String accessToken) {

        getApiHelper().getApiHeader()
                .getProtectedApiHeader().setUserId(userId);
        getApiHelper().getApiHeader()
                .getProtectedApiHeader().setAccessToken(accessToken);

    }
}
