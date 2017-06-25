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

package com.uele.reidx.android;

import com.crashlytics.android.Crashlytics;
import com.uele.reidx.android.logging.CrashlyticsTree;

import io.fabric.sdk.android.Fabric;
import timber.log.Timber;

public class ReidxAppImpl
        extends ReidxApp {

    @Override
    protected void onAfterInjection() {

    }

    @Override
    protected void init() {
        //Start Crashlytics
        Fabric.with(this, new Crashlytics());
        Timber.plant(new CrashlyticsTree());
    }
}
