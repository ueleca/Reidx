package com.uele.reidx.android.ui.activities.profile;

import com.uele.reidx.android.di.scope.PerActivity;
import com.uele.reidx.android.ui.base.ReidxPresenter;


@PerActivity
public interface ProfileReidxPresenter<V extends ProfileReidxView> extends ReidxPresenter<V> {
}