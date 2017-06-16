/*
 * Copyright 2017 Uele, Inc
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.uele.reidx.android.ui.fragments.dash.favoriteFeed;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.uele.reidx.android.R;
import com.uele.reidx.android.ui.base.BaseFragment;
import com.uele.reidx.android.ui.fragments.feed.FeedFragment;

import javax.inject.Inject;

import butterknife.BindView;

public class FavoriteFeedFragment
        extends BaseFragment implements FavoriteFeedReidxView, FavoriteFeedAdapter.Callback {

    private static final String TAG = "FavoriteFeedFragment";

    @Inject
    FavoriteFeedReidxPresenter<FavoriteFeedReidxView> mFavoriteFeedPresenter;

    @Inject
    FavoriteFeedAdapter mFavoriteFeedAdapter;

    @Inject
    LinearLayoutManager mLayoutManager;

    @BindView(R.id.blog_recycler_view)
    RecyclerView mRecyclerView;

    public static FeedFragment newInstance() {
        Bundle args = new Bundle();
        FeedFragment fragment = new FeedFragment();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

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

    @Override
    public void onBlogEmptyViewRetryClick() {

    }
}
