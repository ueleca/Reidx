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
package com.uele.reidx.android.di.module;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;

import com.uele.reidx.android.data.network.model.FeedResponse;
import com.uele.reidx.android.di.qualifier.ActivityContext;
import com.uele.reidx.android.di.scope.PerActivity;
import com.uele.reidx.android.ui.activities.about.AboutPresenter;
import com.uele.reidx.android.ui.activities.about.AboutReidxPresenter;
import com.uele.reidx.android.ui.activities.about.AboutReidxView;
import com.uele.reidx.android.ui.activities.analyzer.AnalyzerPresenter;
import com.uele.reidx.android.ui.activities.analyzer.AnalyzerReidxPresenter;
import com.uele.reidx.android.ui.activities.analyzer.AnalyzerReidxView;
import com.uele.reidx.android.ui.activities.leads.LeadsPresenter;
import com.uele.reidx.android.ui.activities.leads.LeadsReidxPresenter;
import com.uele.reidx.android.ui.activities.leads.LeadsReidxView;
import com.uele.reidx.android.ui.activities.login.LoginPresenter;
import com.uele.reidx.android.ui.activities.login.LoginReidxPresenter;
import com.uele.reidx.android.ui.activities.login.LoginReidxView;
import com.uele.reidx.android.ui.activities.main.MainPresenter;
import com.uele.reidx.android.ui.activities.main.MainReidxPresenter;
import com.uele.reidx.android.ui.activities.main.MainReidxView;
import com.uele.reidx.android.ui.activities.notifications.NotificationsPresenter;
import com.uele.reidx.android.ui.activities.notifications.NotificationsReidxPresenter;
import com.uele.reidx.android.ui.activities.notifications.NotificationsReidxView;
import com.uele.reidx.android.ui.activities.portfolio.PortfolioPresenter;
import com.uele.reidx.android.ui.activities.portfolio.PortfolioReidxPresenter;
import com.uele.reidx.android.ui.activities.portfolio.PortfolioReidxView;
import com.uele.reidx.android.ui.activities.profile.ProfilePresenter;
import com.uele.reidx.android.ui.activities.profile.ProfileReidxPresenter;
import com.uele.reidx.android.ui.activities.profile.ProfileReidxView;
import com.uele.reidx.android.ui.activities.property.PropertyPresenter;
import com.uele.reidx.android.ui.activities.property.PropertyReidxPresenter;
import com.uele.reidx.android.ui.activities.property.PropertyReidxView;
import com.uele.reidx.android.ui.activities.reset.ResetPresenter;
import com.uele.reidx.android.ui.activities.reset.ResetReidxPresenter;
import com.uele.reidx.android.ui.activities.reset.ResetReidxView;
import com.uele.reidx.android.ui.activities.roi.ROIPresenter;
import com.uele.reidx.android.ui.activities.roi.ROIReidxPresenter;
import com.uele.reidx.android.ui.activities.roi.ROIReidxView;
import com.uele.reidx.android.ui.activities.saved.SavedPresenter;
import com.uele.reidx.android.ui.activities.saved.SavedReidxPresenter;
import com.uele.reidx.android.ui.activities.saved.SavedReidxView;
import com.uele.reidx.android.ui.activities.search.SearchPresenter;
import com.uele.reidx.android.ui.activities.search.SearchReidxPresenter;
import com.uele.reidx.android.ui.activities.search.SearchReidxView;
import com.uele.reidx.android.ui.activities.settings.SettingsPresenter;
import com.uele.reidx.android.ui.activities.settings.SettingsReidxPresenter;
import com.uele.reidx.android.ui.activities.settings.SettingsReidxView;
import com.uele.reidx.android.ui.activities.splash.SplashPresenter;
import com.uele.reidx.android.ui.activities.splash.SplashReidxPresenter;
import com.uele.reidx.android.ui.activities.splash.SplashReidxView;
import com.uele.reidx.android.ui.activities.tenant.TenantPresenter;
import com.uele.reidx.android.ui.activities.tenant.TenantReidxPresenter;
import com.uele.reidx.android.ui.activities.tenant.TenantReidxView;
import com.uele.reidx.android.ui.fragments.dash.DashBoardPagerAdapter;
import com.uele.reidx.android.ui.fragments.dash.DashBoardPresenter;
import com.uele.reidx.android.ui.fragments.dash.DashBoardReidxPresenter;
import com.uele.reidx.android.ui.fragments.dash.DashBoardReidxView;
import com.uele.reidx.android.ui.fragments.feed.FeedAdapter;
import com.uele.reidx.android.ui.fragments.feed.FeedPresenter;
import com.uele.reidx.android.ui.fragments.feed.FeedReidxPresenter;
import com.uele.reidx.android.ui.fragments.feed.FeedReidxView;
import com.uele.reidx.android.ui.fragments.liveFeed.LiveFeedAdapter;
import com.uele.reidx.android.ui.fragments.liveFeed.LiveFeedPresenter;
import com.uele.reidx.android.ui.fragments.liveFeed.LiveFeedReidxPresenter;
import com.uele.reidx.android.ui.fragments.liveFeed.LiveFeedReidxView;
import com.uele.reidx.android.ui.fragments.setting.SettingPresenter;
import com.uele.reidx.android.ui.fragments.setting.SettingReidxPresenter;
import com.uele.reidx.android.ui.fragments.setting.SettingReidxView;
import com.uele.reidx.android.utils.rx.AppSchedulerProvider;
import com.uele.reidx.android.utils.rx.SchedulerProvider;

import java.util.ArrayList;

import dagger.Module;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;

@Module
public class ActivityModule {

    private AppCompatActivity mActivity;

    public ActivityModule(AppCompatActivity activity) {
        this.mActivity = activity;
    }

    @Provides
    @ActivityContext
    Context provideContext() {
        return mActivity;
    }

    @Provides
    AppCompatActivity provideActivity() {
        return mActivity;
    }

    @Provides
    CompositeDisposable provideCompositeDisposable() {
        return new CompositeDisposable();
    }

    @Provides
    SchedulerProvider provideSchedulerProvider() {
        return new AppSchedulerProvider();
    }

    @Provides
    @PerActivity
    SplashReidxPresenter<SplashReidxView>
    provideSplashPresenter(SplashPresenter<SplashReidxView> presenter) {
        return presenter;
    }

    @Provides
    @PerActivity
    LoginReidxPresenter<LoginReidxView>
    provideLoginPresenter(LoginPresenter<LoginReidxView> presenter) {
        return presenter;
    }

    @Provides
    @PerActivity
    MainReidxPresenter<MainReidxView>
    provideMainPresenter(MainPresenter<MainReidxView> presenter) {
        return presenter;
    }

    @Provides
    @PerActivity
    SearchReidxPresenter<SearchReidxView>
    provideSearchPresenter(SearchPresenter<SearchReidxView> presenter) {
        return presenter;
    }

    @Provides
    @PerActivity
    SettingsReidxPresenter<SettingsReidxView>
    provideSettingsPresenter(SettingsPresenter<SettingsReidxView> presenter) {
        return presenter;
    }

    @Provides
    @PerActivity
    AnalyzerReidxPresenter<AnalyzerReidxView>
    provideAnalyzerPresenter(AnalyzerPresenter<AnalyzerReidxView> presenter) {
        return presenter;
    }

    @Provides
    @PerActivity
    LeadsReidxPresenter<LeadsReidxView>
    provideLeadsPresenter(LeadsPresenter<LeadsReidxView> presenter) {
        return presenter;
    }

    @Provides
    @PerActivity
    ResetReidxPresenter<ResetReidxView>
    provideResetPresenter(ResetPresenter<ResetReidxView> presenter) {
        return presenter;
    }

    @Provides
    @PerActivity
    SavedReidxPresenter<SavedReidxView>
    provideSavedPresenter(SavedPresenter<SavedReidxView> presenter) {
        return presenter;
    }

    @Provides
    @PerActivity
    TenantReidxPresenter<TenantReidxView>
    provideTenantPresenter(TenantPresenter<TenantReidxView> presenter) {
        return presenter;
    }

    @Provides
    @PerActivity
    PropertyReidxPresenter<PropertyReidxView>
    providePropertyPresenter(PropertyPresenter<PropertyReidxView> presenter) {
        return presenter;
    }

    @Provides
    @PerActivity
    ProfileReidxPresenter<ProfileReidxView>
    provideProfilePresenter(ProfilePresenter<ProfileReidxView> presenter) {
        return presenter;
    }

    @Provides
    @PerActivity
    ROIReidxPresenter<ROIReidxView>
    provideROIPresenter(ROIPresenter<ROIReidxView> presenter) {
        return presenter;
    }

    @Provides
    @PerActivity
    NotificationsReidxPresenter<NotificationsReidxView>
    provideNotificationsPresenter(NotificationsPresenter<NotificationsReidxView> presenter) {
        return presenter;
    }

    @Provides
    @PerActivity
    PortfolioReidxPresenter<PortfolioReidxView>
    providePortfolioPresenter(PortfolioPresenter<PortfolioReidxView> presenter) {
        return presenter;
    }

    @Provides
    AboutReidxPresenter<AboutReidxView>
    provideAboutPresenter(AboutPresenter<AboutReidxView> presenter) {
        return presenter;
    }

    @Provides
    SettingReidxPresenter<SettingReidxView>
    provideSettingPresenter(SettingPresenter<SettingReidxView> presenter) {
        return presenter;
    }

    @Provides
    FeedReidxPresenter<FeedReidxView>
    provideFeedPresenter(FeedPresenter<FeedReidxView> presenter) {
        return presenter;
    }

    @Provides
    LiveFeedReidxPresenter<LiveFeedReidxView>
    provideLiveFeedPresenter(LiveFeedPresenter<LiveFeedReidxView> presenter) {
        return presenter;
    }

    @Provides
    DashBoardReidxPresenter<DashBoardReidxView>
    provideDashBoardPresenter(DashBoardPresenter< DashBoardReidxView> presenter) {
        return presenter;
    }

    @Provides
    FeedAdapter provideFeedAdapter() {
        return new FeedAdapter(new ArrayList<FeedResponse.Blog>());
    }

    @Provides
    DashBoardPagerAdapter provideDashBoardPagerAdapter(AppCompatActivity activity) {
        return new DashBoardPagerAdapter(activity.getSupportFragmentManager());
    }
    @Provides
    LiveFeedAdapter provideLiveFeedAdapter() {
        return new LiveFeedAdapter(new ArrayList<FeedResponse.Blog>());
    }

    @Provides
    LinearLayoutManager provideLinearLayoutManager(AppCompatActivity activity) {
        return new LinearLayoutManager(activity);
    }
}
