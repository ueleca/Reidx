package com.uele.reidx.android.ui.activities.property;

import com.uele.reidx.android.di.scope.PerActivity;
import com.uele.reidx.android.ui.base.ReidxPresenter;


@PerActivity
public interface PropertyReidxPresenter<V extends PropertyReidxView> extends ReidxPresenter<V> {
}