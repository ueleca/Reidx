/*
 * Copyright 2017 Uele, Inc
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

package com.uele.reidx.android.ui.fragments.dash.dealsFeed;

import com.androidnetworking.error.ANError;
import com.uele.reidx.android.data.network.model.PropertyResponse;
import com.uele.reidx.android.ui.base.BasePresenter;
import com.uele.reidx.android.utils.rx.SchedulerProvider;

import javax.inject.Inject;

import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;

public class DealsFeedPresenter<V extends DealsFeedReidxView,
        I extends DealsFeedReidxInteractor> extends BasePresenter<V, I>
        implements DealsFeedReidxPresenter<V, I> {

    private static final String TAG = DealsFeedPresenter.class.getSimpleName();

    @Inject
    public DealsFeedPresenter(I reidxInteractor,
                              SchedulerProvider schedulerProvider,
                              CompositeDisposable compositeDisposable) {
        super(reidxInteractor, schedulerProvider, compositeDisposable);
    }

    @Override
    public void onViewPrepared() {
        getReidxView().showLoading();
        getCompositeDisposable().add(getInteractor()
                .getDealsApiCall()
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(new Consumer<PropertyResponse>() {
                    @Override
                    public void accept(@NonNull PropertyResponse feedResponse)
                            throws Exception {
                        if (feedResponse != null && feedResponse.getData() != null) {
                            getReidxView().updateBlog(feedResponse.getData());
                        }
                        getReidxView().hideLoading();
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(@NonNull Throwable throwable)
                            throws Exception {
                        if (!isViewAttached()) {
                            return;
                        }

                        getReidxView().hideLoading();

                        // handle the error here
                        if (throwable instanceof ANError) {
                            ANError anError = (ANError) throwable;
                            handleApiError(anError);
                        }
                    }
                }));
    }
}