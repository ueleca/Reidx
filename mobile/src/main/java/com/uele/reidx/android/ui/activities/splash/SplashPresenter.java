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

package com.uele.reidx.android.ui.activities.splash;

import com.uele.reidx.android.R;
import com.uele.reidx.android.ui.base.BasePresenter;
import com.uele.reidx.android.utils.rx.SchedulerProvider;

import javax.inject.Inject;

import io.reactivex.ObservableSource;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;

public class SplashPresenter<V extends SplashReidxView , I extends SplashReidxInteractor>
        extends BasePresenter<V, I> implements SplashReidxPresenter<V, I> {

    private static final String TAG = SplashPresenter.class.getSimpleName();

    @Inject
    public SplashPresenter(I reidxInteractor,
                           SchedulerProvider schedulerProvider,
                           CompositeDisposable compositeDisposable) {
        super(reidxInteractor, schedulerProvider, compositeDisposable);
    }

    @Override
    public void onAttach(V reidxView) {
        super.onAttach(reidxView);

        getReidxView().startSyncService();

        getCompositeDisposable().add(getInteractor()
                .seedDatabaseQuestions()
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .concatMap(new Function<Boolean, ObservableSource<Boolean>>() {
                    @Override
                    public ObservableSource<Boolean> apply(Boolean aBoolean) throws Exception {
                        return getInteractor().seedDatabaseOptions();
                    }
                })
                .subscribe(new Consumer<Boolean>() {
                    @Override
                    public void accept(Boolean aBoolean) throws Exception {
                        if (!isViewAttached()) {
                            return;
                        }
                        decideReidxActivity();
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        if (!isViewAttached()) {
                            return;
                        }
                        getReidxView().onError(R.string.some_error);
                        decideReidxActivity();
                    }
                }));
    }

    private void decideReidxActivity() {
        if (getInteractor().getCurrentUserLoggedInMode()
                == DataManager.LoggedInMode.LOGGED_IN_MODE_LOGGED_OUT.getType()) {
            getReidxView().openLoginActivity();
        } else {
            getReidxView().openMainActivity();
        }
    }
}