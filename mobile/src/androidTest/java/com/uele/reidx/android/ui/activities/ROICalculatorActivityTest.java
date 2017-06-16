package com.uele.reidx.android.ui.activities;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.uele.reidx.android.ui.activities.roi.ROIActivity;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class ROICalculatorActivityTest {

    @Rule
    public ActivityTestRule<ROIActivity> activityTestRule
            = new ActivityTestRule<>(ROIActivity.class);

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }
}