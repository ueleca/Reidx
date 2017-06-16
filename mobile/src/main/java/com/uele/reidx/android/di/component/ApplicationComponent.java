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

/*
 * Created by Brian Donaldson on 3/13/17.
 */

import android.app.Application;
import android.content.Context;

import com.uele.reidx.android.ReidxApp;
import com.uele.reidx.android.data.DataManager;
import com.uele.reidx.android.di.module.ApplicationModule;
import com.uele.reidx.android.di.qualifier.ApplicationContext;
import com.uele.reidx.android.service.SyncService;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {
    void inject(ReidxApp app);
    void inject(SyncService service);

    @ApplicationContext Context appContext();

    Application application();
    DataManager getDataManager();
    //SearchManager searchManager();
    //Realm realm();
}