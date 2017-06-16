package com.uele.reidx.android.ui.activities.tenant;

import com.uele.reidx.android.di.scope.PerActivity;
import com.uele.reidx.android.ui.base.ReidxPresenter;

@PerActivity
public interface TenantReidxPresenter<V extends TenantReidxView> extends ReidxPresenter<V> {
}
