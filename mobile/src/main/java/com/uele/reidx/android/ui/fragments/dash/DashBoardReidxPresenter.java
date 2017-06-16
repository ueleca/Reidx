package com.uele.reidx.android.ui.fragments.dash;

import com.uele.reidx.android.di.scope.PerActivity;
import com.uele.reidx.android.ui.base.ReidxPresenter;

@PerActivity
public interface DashBoardReidxPresenter <V extends DashBoardReidxView> extends ReidxPresenter<V> {
    void onViewPrepared();
}