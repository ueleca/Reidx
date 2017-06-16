package com.uele.reidx.android.ui.activities.login;

import com.uele.reidx.android.di.scope.PerActivity;
import com.uele.reidx.android.ui.base.ReidxPresenter;

@PerActivity
public interface LoginReidxPresenter<V extends LoginReidxView> extends ReidxPresenter<V> {
    void onServerLoginClick(String email, String password);
}
