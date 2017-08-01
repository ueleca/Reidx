/*
 * Copyright (C) 2017 Uele, Inc.
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

package com.uele.reidx.android.ui.fragments.feed;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.uele.reidx.android.R;
import com.uele.reidx.android.data.network.model.PropertyResponse;
import com.uele.reidx.android.di.component.ActivityComponent;
import com.uele.reidx.android.ui.base.BaseFragment;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FeedFragment
        extends BaseFragment implements FeedReidxView, FeedAdapter.Callback {

    private static final String TAG = "FeedFragment";

    @Inject
    FeedReidxPresenter<FeedReidxView> mFeedPresenter;

    @Inject
    FeedAdapter mFeedAdapter;

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

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_feed, container, false);

        ActivityComponent component = getActivityComponent();
        if (component != null) {
            component.inject(this);
            setUnBinder(ButterKnife.bind(this, view));
            mFeedPresenter.onAttach(this);
            mFeedAdapter.setCallback(this);
        }
        return view;
    }

    @Override
    protected void setUp(View view) {
        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setAdapter(mFeedAdapter);

        mFeedPresenter.onViewPrepared();
    }

    @Override
    public void onBlogEmptyViewRetryClick() {

    }

    @Override
    public void updateBlog(List<PropertyResponse.Blog> blogList) {
        mFeedAdapter.addItems(blogList);
    }

    @Override
    public void onDestroyView() {
        mFeedPresenter.onDetach();
        super.onDestroyView();
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
