package com.uele.reidx.android.ui.fragments.dash;

import com.uele.reidx.android.data.DataManager;
import com.uele.reidx.android.ui.base.BasePresenter;
import com.uele.reidx.android.utils.rx.SchedulerProvider;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

public class DashBoardPresenter<V extends DashBoardReidxView> extends BasePresenter<V>
        implements DashBoardReidxPresenter<V> {

    private static final String TAG = DashBoardPresenter.class.getSimpleName();

    @Inject
    public DashBoardPresenter(DataManager dataManager,
                               SchedulerProvider schedulerProvider,
                               CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }

    @Override
    public void onViewPrepared() {

    }
}