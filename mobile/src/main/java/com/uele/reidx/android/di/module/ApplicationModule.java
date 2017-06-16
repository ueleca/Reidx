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

/*
 * Created by Brian Donaldson on 3/13/17.
 */

import android.app.Application;
import android.app.SearchManager;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.view.inputmethod.InputMethodManager;

import com.uele.reidx.android.BuildConfig;
import com.uele.reidx.android.R;
import com.uele.reidx.android.data.AppDataManager;
import com.uele.reidx.android.data.DataManager;
import com.uele.reidx.android.data.db.AppDbHelper;
import com.uele.reidx.android.data.db.DbHelper;
import com.uele.reidx.android.data.network.ApiHeader;
import com.uele.reidx.android.data.network.ApiHelper;
import com.uele.reidx.android.data.network.AppApiHelper;
import com.uele.reidx.android.data.prefs.AppPreferencesHelper;
import com.uele.reidx.android.data.prefs.PreferencesHelper;
import com.uele.reidx.android.di.ApiInfo;
import com.uele.reidx.android.di.DatabaseInfo;
import com.uele.reidx.android.di.PreferenceInfo;
import com.uele.reidx.android.di.qualifier.ApplicationContext;
import com.uele.reidx.android.utils.AppConstants;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

@Module
public class ApplicationModule {

    private final Application mApplication;

    public ApplicationModule(Application application) {
        mApplication = application;
    }

    @Provides
    @ApplicationContext
    Context provideContext() {
        return mApplication;
    }

    @Provides
    Application provideApplication() {
        return mApplication;
    }

    @Provides
    @DatabaseInfo
    String provideDatabaseName() {
        return AppConstants.DB_NAME;
    }

    @Provides
    @ApiInfo
    String provideApiKey() {
        return BuildConfig.API_KEY;
    }

    @Provides
    @PreferenceInfo
    String providePreferenceName() {
        return AppConstants.PREF_NAME;
    }

    @Provides
    @Singleton
    DataManager provideDataManager(AppDataManager appDataManager) {
        return appDataManager;
    }

    @Provides
    @Singleton
    DbHelper provideDbHelper(AppDbHelper appDbHelper) {
        return appDbHelper;
    }

    @Provides
    @Singleton
    PreferencesHelper providePreferencesHelper(AppPreferencesHelper appPreferencesHelper) {
        return appPreferencesHelper;
    }

    @Provides
    @Singleton
    ApiHelper provideApiHelper(AppApiHelper appApiHelper) {
        return appApiHelper;
    }

    @Provides
    @Singleton
    ApiHeader.ProtectedApiHeader provideProtectedApiHeader(@ApiInfo String apiKey,
                                                           PreferencesHelper preferencesHelper) {
        return new ApiHeader.ProtectedApiHeader(
                apiKey,
                preferencesHelper.getCurrentUserId(),
                preferencesHelper.getAccessToken());
    }

    @Provides
    @Singleton
    CalligraphyConfig provideCalligraphyDefaultConfig() {
        return new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/source-sans-pro/SourceSansPro-Regular.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build();
    }

    @Provides
    PackageInfo providePackageInfo(@ApplicationContext Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Provides
    InputMethodManager provideInputMethodManager(@ApplicationContext Context context) {
        return (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
    }

    @Provides
    SearchManager provideSearchManager(@ApplicationContext Context context) {
        return (SearchManager) context.getSystemService(Context.SEARCH_SERVICE);
    }
}


/*

    @Provides
    static RealmConfiguration provideRealmConfiguration(@ApplicationContext Context context) {
        RealmConfiguration.Builder builder = new RealmConfiguration.Builder(context);
        if (BuildConfig.DEBUG) {
            builder = builder.deleteRealmIfMigrationNeeded();
        }
        return builder.build();
    }

    @Provides
    static Realm provideRealm(RealmConfiguration realmConfiguration) {
        return Realm.getInstance(realmConfiguration);

           @Provides
    RealmService provideRealmService(final Realm realm) {
        return new RealmService(realm);
    }
    }


    @Provides
    DatabaseRealm provideDatabaseRealm() {
        return new DatabaseRealm();
    }
 */
