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

package com.uele.reidx.android.ui.fragments.deals;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.uele.reidx.android.R;
import com.uele.reidx.android.di.component.ActivityComponent;
import com.uele.reidx.android.ui.base.BaseFragment;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DealsFragment
        extends BaseFragment implements DealsReidxView {

    private static final String TAG = "DealsFragment";

    @BindView(R.id.feed_view_pager)
    ViewPager mViewPager;

    @BindView(R.id.tab_layout)
    TabLayout mTabLayout;

    @Inject
    DealsPagerAdapter mDealsPagerAdapter;

    @Inject
    DealsReidxPresenter<DealsReidxView, DealsReidxInteractor> mDealsPresenter;


    public static DealsFragment newInstance() {
        Bundle args = new Bundle();
        DealsFragment fragment = new DealsFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_deals, container, false);

        ActivityComponent component = getActivityComponent();
        if (component != null) {
            component.inject(this);
            setUnBinder(ButterKnife.bind(this, view));
            mDealsPresenter.onAttach(this);

        }
        return view;
    }

    @Override
    protected void setUp(View view){
        mDealsPagerAdapter.setCount(3);

        mViewPager.setAdapter(mDealsPagerAdapter);

        mTabLayout.addTab(mTabLayout.newTab().setText(getString(R.string.blog)));
        mTabLayout.addTab(mTabLayout.newTab().setText(getString(R.string.open_source)));

        mViewPager.setOffscreenPageLimit(mTabLayout.getTabCount());

        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTabLayout));

        mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {

            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                mViewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
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
