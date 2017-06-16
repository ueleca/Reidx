package com.uele.reidx.android.ui.activities.main;

import com.uele.reidx.android.di.scope.PerActivity;
import com.uele.reidx.android.ui.base.ReidxPresenter;

@PerActivity
public interface MainReidxPresenter<V extends MainReidxView> extends ReidxPresenter<V> {
}
