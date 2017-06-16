package com.uele.reidx.android.ui.fragments.setting;

import com.uele.reidx.android.data.DataManager;
import com.uele.reidx.android.ui.base.BasePresenter;
import com.uele.reidx.android.utils.rx.SchedulerProvider;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

public class SettingPresenter<V extends SettingReidxView> extends BasePresenter<V>
        implements SettingReidxPresenter<V> {

    private static final String TAG = SettingPresenter.class.getSimpleName();

    @Inject
    public SettingPresenter(DataManager dataManager,
                            SchedulerProvider schedulerProvider,
                            CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }
}
