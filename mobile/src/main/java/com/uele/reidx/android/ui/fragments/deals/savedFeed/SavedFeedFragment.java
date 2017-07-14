package com.uele.reidx.android.ui.fragments.deals.savedFeed;

import android.os.Bundle;
import android.support.annotation.StringRes;
import android.view.View;

import com.uele.reidx.android.ui.base.BaseFragment;

import javax.inject.Inject;

public class SavedFeedFragment
        extends BaseFragment implements SavedFeedReidxView {

    private static final String TAG = "SavedFeedFragment";

    @Inject
    SavedFeedReidxPresenter<SavedFeedReidxView> mSavedFeedPresenter;

    public static SavedFeedFragment newInstance() {
        Bundle args = new Bundle();
        SavedFeedFragment fragment = new SavedFeedFragment();
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
