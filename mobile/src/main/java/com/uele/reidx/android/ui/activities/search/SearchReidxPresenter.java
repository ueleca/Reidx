package com.uele.reidx.android.ui.activities.search;

import com.uele.reidx.android.di.scope.PerActivity;
import com.uele.reidx.android.ui.base.ReidxPresenter;


@PerActivity
public interface SearchReidxPresenter<V extends SearchReidxView> extends ReidxPresenter<V> {
}