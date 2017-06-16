package com.uele.reidx.android.ui.activities;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.uele.reidx.android.ui.activities.tenant.TenantActivity;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class TenantAnalyzerActivityTest {

    @Rule
    public final ActivityTestRule<TenantActivity> activityTestRule =
            new ActivityTestRule<>(TenantActivity.class);

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }
}