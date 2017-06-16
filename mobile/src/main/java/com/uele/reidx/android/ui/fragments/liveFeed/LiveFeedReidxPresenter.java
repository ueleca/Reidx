package com.uele.reidx.android.ui.fragments.liveFeed;

import com.uele.reidx.android.di.scope.PerActivity;
import com.uele.reidx.android.ui.base.ReidxPresenter;

/*
 * Created by Brian Donaldson on 3/13/17.
 */

@PerActivity
public interface LiveFeedReidxPresenter<V extends LiveFeedReidxView> extends ReidxPresenter<V> {
    void onViewPrepared();
}