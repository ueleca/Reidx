package com.uele.reidx.android.ui.activities.settings;

import com.uele.reidx.android.di.scope.PerActivity;
import com.uele.reidx.android.ui.base.ReidxPresenter;

@PerActivity
public interface SettingsReidxPresenter <V extends SettingsReidxView> extends ReidxPresenter<V> {
}