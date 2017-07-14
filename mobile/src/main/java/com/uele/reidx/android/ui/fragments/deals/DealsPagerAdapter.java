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
