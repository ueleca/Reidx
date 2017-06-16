package com.uele.reidx.android.ui.activities.saved;

import com.uele.reidx.android.di.scope.PerActivity;
import com.uele.reidx.android.ui.base.ReidxPresenter;

@PerActivity
public interface SavedReidxPresenter<V extends SavedReidxView> extends ReidxPresenter<V> {
}