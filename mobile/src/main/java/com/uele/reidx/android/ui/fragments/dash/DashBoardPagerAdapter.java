package com.uele.reidx.android.ui.fragments.dash;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.uele.reidx.android.ui.fragments.dash.dealFeed.DealFeedFragment;
import com.uele.reidx.android.ui.fragments.dash.favoriteFeed.FavoriteFeedFragment;
import com.uele.reidx.android.ui.fragments.dash.myDealFeed.MyDealFeedFragment;

public class DashBoardPagerAdapter
        extends FragmentStatePagerAdapter {

    private int mTabCount;

    public DashBoardPagerAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
        this.mTabCount = 0;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                return DealFeedFragment.newInstance();
            case 1:
                return FavoriteFeedFragment.newInstance();
            case 2:
                return MyDealFeedFragment.newInstance();
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
