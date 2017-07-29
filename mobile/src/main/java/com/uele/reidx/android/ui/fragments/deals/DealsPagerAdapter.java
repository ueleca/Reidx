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

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.uele.reidx.android.ui.fragments.deals.appliedFeed.AppliedFeedFragment;
import com.uele.reidx.android.ui.fragments.deals.savedFeed.SavedFeedFragment;
import com.uele.reidx.android.ui.fragments.deals.searchesFeed.SearchesFeedFragment;
import com.uele.reidx.android.ui.fragments.deals.viewedFeed.ViewedFeedFragment;

public class DealsPagerAdapter
        extends FragmentStatePagerAdapter {

    private int mTabCount;

    public DealsPagerAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
        this.mTabCount = 0;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                return SearchesFeedFragment.newInstance();
            case 1:
                return SavedFeedFragment.newInstance();
            case 2:
                return AppliedFeedFragment.newInstance();
            case 3:
                return ViewedFeedFragment.newInstance();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mTabCount;
    }

    public void setCount(int count) {
        mTabCount = count;
    }
}
