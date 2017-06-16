package com.uele.reidx.android.ui.activities;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.uele.reidx.android.ui.activities.analyzer.AnalyzerActivity;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class DealAnalyzerActivityTest {

    @Rule
    public final ActivityTestRule<AnalyzerActivity> activityTestRule
            = new ActivityTestRule<>(AnalyzerActivity.class);

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }
}