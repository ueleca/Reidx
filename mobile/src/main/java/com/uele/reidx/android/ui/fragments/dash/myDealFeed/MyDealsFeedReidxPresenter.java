package com.uele.reidx.android.ui.fragments.dash.myDealFeed;

import com.uele.reidx.android.ui.base.ReidxPresenter;

public interface MyDealsFeedReidxPresenter <V extends MyDealsFeedReidxView,
        I extends MyDealsFeedReidxInteractor> extends ReidxPresenter<V, I> {

    void onViewPrepared();
}