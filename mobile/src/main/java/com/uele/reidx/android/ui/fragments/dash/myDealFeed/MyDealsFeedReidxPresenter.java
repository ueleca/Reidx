package com.uele.reidx.android.ui.fragments.dash.myDealFeed;

import com.uele.reidx.android.di.scope.PerActivity;
import com.uele.reidx.android.ui.base.ReidxPresenter;

@PerActivity
public interface MyDealsFeedReidxPresenter<V extends MyDealsFeedReidxView> extends ReidxPresenter<V> {
    void onViewPrepared();
}