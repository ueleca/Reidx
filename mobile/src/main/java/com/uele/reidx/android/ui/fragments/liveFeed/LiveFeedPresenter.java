/*
 * Copyright 2016 Brian Donaldson
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

package com.uele.reidx.android.ui.fragments.liveFeed;

import com.uele.reidx.android.data.DataManager;
import com.uele.reidx.android.ui.base.BasePresenter;
import com.uele.reidx.android.ui.fragments.feed.FeedPresenter;
import com.uele.reidx.android.utils.rx.SchedulerProvider;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

public class LiveFeedPresenter<V extends LiveFeedReidxView> extends BasePresenter<V>
        implements LiveFeedReidxPresenter<V> {

        private static final String TAG = FeedPresenter.class.getSimpleName();

    @Inject
    public LiveFeedPresenter(DataManager dataManager,
                         SchedulerProvider schedulerProvider,
                         CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }

    @Override
    public void onViewPrepared() {

    }
}




        /*
        if (mDeals == null) return;
        Observable.from(mDeals)
                .flatMap(LiveFeedResponse -> LiveFeedLoader.getWeatherForCityId(LiveFeedResponse.id()))
                .filter(newResponse -> newResponse != null) // Open Weather Map free API call limits are strict
                .subscribe(this::weatherLoaded,
                        throwable -> Timber.d("Error refreshing data", throwable),
                        this::setData);
         */