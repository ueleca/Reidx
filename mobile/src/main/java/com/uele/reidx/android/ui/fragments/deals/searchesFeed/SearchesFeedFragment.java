package com.uele.reidx.android.ui.fragments.deals.searchesFeed;

import android.os.Bundle;
import android.support.annotation.StringRes;
import android.view.View;

import com.uele.reidx.android.ui.base.BaseFragment;

import javax.inject.Inject;

public class SearchesFeedFragment
        extends BaseFragment implements SearchesFeedReidxView {

    private static final String TAG = "SearchesFeedFragment";

    @Inject
    SearchesFeedReidxPresenter<SearchesFeedReidxView> mSearchesFeedPresenter;

    public static SearchesFeedFragment newInstance() {
        Bundle args = new Bundle();
        SearchesFeedFragment fragment = new SearchesFeedFragment();
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

