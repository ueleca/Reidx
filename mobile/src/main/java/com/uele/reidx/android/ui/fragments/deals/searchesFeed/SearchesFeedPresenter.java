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

package com.uele.reidx.android.ui.fragments.deals.searchesFeed;

import com.uele.reidx.android.ui.base.BasePresenter;
import com.uele.reidx.android.utils.rx.SchedulerProvider;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

public class SearchesFeedPresenter<V extends SearchesFeedReidxView,
        I extends SearchesFeedReidxInteractor> extends BasePresenter<V, I>
        implements SearchesFeedReidxPresenter<V, I> {

    private static final String TAG = SearchesFeedPresenter.class.getSimpleName();

    @Inject
    public SearchesFeedPresenter(I reidxInteractor,
                          SchedulerProvider schedulerProvider,
                          CompositeDisposable compositeDisposable) {
        super(reidxInteractor, schedulerProvider, compositeDisposable);
    }
}
