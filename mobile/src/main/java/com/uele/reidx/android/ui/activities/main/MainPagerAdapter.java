/*
 * Copyright 2016 Brian Donaldson
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.uele.reidx.android.ui.activities.main;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.uele.reidx.android.R;
import com.uele.reidx.android.ui.fragments.dash.favoriteFeed.FavoriteFeedFragment;
import com.uele.reidx.android.ui.fragments.dash.myDealFeed.MyDealFeedFragment;
import com.uele.reidx.android.ui.fragments.liveFeed.LiveFeedFragment;


public class MainPagerAdapter
        extends FragmentPagerAdapter {

    private final Resources resources;

    int [] tabIcons = {
            R.drawable.ic_deals,
            R.drawable.ic_favorites_black,
            R.drawable.ic_my_deals
    };

    /**
     * Create pager adapter
     *
     * @param resources
     * @param fragmentManager
     */
    MainPagerAdapter(final Resources resources,
                     final FragmentManager fragmentManager) {
        super(fragmentManager);
        this.resources = resources;
    }

    @Override
    public Fragment getItem(int position) {
        final Fragment result;
        switch (position) {
            case 0:
                result = LiveFeedFragment.newInstance();
                break;
            case 1:
                result = FavoriteFeedFragment.newInstance();
                break;
            case 2:
                result = MyDealFeedFragment.newInstance();
                break;
            default:
                result = null;
                break;
        }

        if (result != null) {
            result.setArguments(new Bundle()); //TODO do we need this?
        }
        return result;
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        // return null to display only the icon
        return null;
    }

    public  Drawable getIcon(int position) {
        return resources.getDrawable(tabIcons[position]);
    }
}
