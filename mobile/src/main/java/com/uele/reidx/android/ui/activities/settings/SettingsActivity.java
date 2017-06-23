/*
 * Copyright 2016 Brian Donaldson
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

package com.uele.reidx.android.ui.activities.settings;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.Toolbar;

import com.uele.reidx.android.R;
import com.uele.reidx.android.ui.base.BaseActivity;
import com.uele.reidx.android.ui.fragments.setting.SettingFragment;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SettingsActivity
        extends BaseActivity implements SettingsReidxView {

    @BindView(R.id.toolbar)
    Toolbar mToolBar;

    @Inject
    SettingsReidxPresenter<SettingsReidxView> mSettingsPresenter;

    public static Intent getStartIntent(Context context) {
        Intent intent = new Intent(context, SettingsActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setUp();
        setContentView(R.layout.activity_settings);
        getActivityComponent().inject(this);
        setUnBinder(ButterKnife.bind(this));
        mSettingsPresenter.onAttach(SettingsActivity.this);
    }

    @Override
    protected void setUp() {

    }

    @Override
    public void onFragmentDetached(String tag) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment fragment = fragmentManager.findFragmentByTag(tag);
        if (fragment != null) {
            fragmentManager
                    .beginTransaction()
                    .disallowAddToBackStack()
                    .setCustomAnimations(R.anim.slide_left, R.anim.slide_right)
                    .remove(fragment)
                    .commitNow();
        }
    }

    @Override
    public void showSettingFragment() {
        SettingFragment settingFragment = SettingFragment.newInstance();
        getFragmentManager().beginTransaction().replace(R.id.fragment_content, settingFragment).commit();

       /* getSupportFragmentManager()
                .beginTransaction()
                .disallowAddToBackStack()
                .setCustomAnimations(R.anim.slide_left, R.anim.slide_right)
                .replace(R.id.fragment_content, settingFragment, SettingFragment.TAG)
                .commit();*/
    }
}

