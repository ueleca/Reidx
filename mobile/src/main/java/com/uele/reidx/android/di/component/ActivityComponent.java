/*
 * Copyright 2016 Brian Donaldson
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.uele.reidx.android.di.component;

import com.uele.reidx.android.di.module.ActivityModule;
import com.uele.reidx.android.di.scope.PerActivity;
import com.uele.reidx.android.ui.activities.about.AboutActivity;
import com.uele.reidx.android.ui.activities.analyzer.AnalyzerActivity;
import com.uele.reidx.android.ui.activities.leads.LeadsActivity;
import com.uele.reidx.android.ui.activities.login.LoginActivity;
import com.uele.reidx.android.ui.activities.main.MainActivity;
import com.uele.reidx.android.ui.activities.notifications.NotificationsActivity;
import com.uele.reidx.android.ui.activities.portfolio.PortfolioActivity;
import com.uele.reidx.android.ui.activities.profile.ProfileActivity;
import com.uele.reidx.android.ui.activities.property.PropertyActivity;
import com.uele.reidx.android.ui.activities.reset.ResetActivity;
import com.uele.reidx.android.ui.activities.roi.ROIActivity;
import com.uele.reidx.android.ui.activities.saved.SavedActivity;
import com.uele.reidx.android.ui.activities.search.SearchActivity;
import com.uele.reidx.android.ui.activities.settings.SettingsActivity;
import com.uele.reidx.android.ui.activities.splash.SplashActivity;
import com.uele.reidx.android.ui.activities.tenant.TenantActivity;
import com.uele.reidx.android.ui.fragments.dash.DashBoardFragment;
import com.uele.reidx.android.ui.fragments.deals.DealsFragment;
import com.uele.reidx.android.ui.fragments.feed.FeedFragment;
import com.uele.reidx.android.ui.fragments.liveFeed.LiveFeedFragment;
import com.uele.reidx.android.ui.fragments.setting.SettingFragment;

import dagger.Component;

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {
    void inject(AboutActivity activity);
    void inject(AnalyzerActivity activity);
    void inject(LoginActivity activity);
    void inject(LeadsActivity activity);
    void inject(MainActivity activity);
    void inject(NotificationsActivity activity);
    void inject(PortfolioActivity activity);
    void inject(PropertyActivity activity);
    void inject(ProfileActivity activity);
    void inject(ResetActivity activity);
    void inject(ROIActivity activity);
    void inject(SearchActivity activity);
    void inject(SavedActivity activity);
    void inject(SplashActivity activity);
    void inject(SettingsActivity activity);
    void inject(TenantActivity activity);

    void inject(DashBoardFragment fragment);
    void inject(DealsFragment fragment);
   // void inject(FavoriteFeedFragment fragment);
   void inject(FeedFragment fragment);
    void inject(LiveFeedFragment fragment);
   // void inject(MyDealFeedFragment fragment);
    void inject(SettingFragment fragment);

}