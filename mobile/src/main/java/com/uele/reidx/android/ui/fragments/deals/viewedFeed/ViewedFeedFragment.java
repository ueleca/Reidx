package com.uele.reidx.android.ui.fragments.deals.viewedFeed;

import android.os.Bundle;
import android.support.annotation.StringRes;
import android.view.View;

import com.uele.reidx.android.ui.base.BaseFragment;

import javax.inject.Inject;

public class ViewedFeedFragment
        extends BaseFragment implements ViewedFeedReidxView {

    private static final String TAG = "ViewedFeedFragment";

    @Inject
    ViewedFeedReidxPresenter<ViewedFeedReidxView> mViewedFeedPresenter;

    public static ViewedFeedFragment newInstance() {
        Bundle args = new Bundle();
        ViewedFeedFragment fragment = new ViewedFeedFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected void setUp(View view) {

    }

    @Override
    public void showMessage(String message) {

    }

    @Override
    public void showMessage(@StringRes int resId) {

    }

    @Override
    public void showOfflineMessage(boolean isCritical) {

    }

    @Override
    public void showErrorMessage(Throwable throwable) {

    }
}

