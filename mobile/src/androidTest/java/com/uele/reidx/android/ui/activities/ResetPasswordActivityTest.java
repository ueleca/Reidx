package com.uele.reidx.android.ui.activities;

import android.content.pm.PackageManager;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.uele.reidx.android.R;
import com.uele.reidx.android.ui.activities.reset.ResetActivity;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withHint;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
public class ResetPasswordActivityTest {

    @Rule
    public final ActivityTestRule<ResetActivity> activityTestRule =
            new ActivityTestRule<>(ResetActivity.class);

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void testViewElements() throws PackageManager.NameNotFoundException {
        onView(withId(R.id.resetEmailEdt)).check(matches(withHint(R.string.hint_email)));
        onView(withId(R.id.resetPasswordBtn)).
                check(matches(withText(R.string.button_reset_password)));
    }

    @Test
    public void testResetPasswordButton() {
        onView(withId(R.id.resetEmailEdt)).perform(typeText("briand@ca.ibm.com"), closeSoftKeyboard());
        onView(withId(R.id.resetPasswordBtn)).perform(click());
    }

    @After
    public void tearDown() throws Exception {

    }
}