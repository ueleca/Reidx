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

package com.uele.reidx.android.service;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

import com.uele.reidx.android.ReidxApp;
import com.uele.reidx.android.di.component.DaggerServiceComponent;
import com.uele.reidx.android.di.component.ServiceComponent;
import com.uele.reidx.android.utils.ReidxLogger;

import javax.inject.Inject;

public class SyncService
        extends Service {

    private static final String TAG = "SyncService";

    @Inject
    SyncInteractor mInteractor;

    public static Intent getStartIntent(Context context) {
        return new Intent(context, SyncService.class);
    }

    public static void start(Context context) {
        Intent starter = new Intent(context, SyncService.class);
        context.startService(starter);
    }

    public static void stop(Context context) {
        context.stopService(new Intent(context, SyncService.class));
    }

    @Override
    public void onCreate() {
        super.onCreate();
        ServiceComponent component = DaggerServiceComponent.builder()
                .applicationComponent(((ReidxApp) getApplication()).getComponent())
                .build();
        component.inject(this);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        ReidxLogger.d(TAG, "SyncService started");
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        ReidxLogger.d(TAG, "SyncService stopped");
        super.onDestroy();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
