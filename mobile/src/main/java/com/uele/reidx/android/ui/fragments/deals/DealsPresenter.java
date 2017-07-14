package com.uele.reidx.android.ui.fragments.deals;

import com.uele.reidx.android.data.DataManager;
import com.uele.reidx.android.ui.base.BasePresenter;
import com.uele.reidx.android.utils.rx.SchedulerProvider;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

public class DealsPresenter<V extends DealsReidxView> extends BasePresenter<V>
        implements DealsReidxPresenter<V> {

    private static final String TAG = DealsPresenter.class.getSimpleName();

    @Inject
    public DealsPresenter(DataManager dataManager,
                          SchedulerProvider schedulerProvider,
                          CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }
}