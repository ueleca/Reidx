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

package com.uele.reidx.android.ui.activities.login;

import android.content.pm.PackageManager;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.intent.rule.IntentsTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.uele.reidx.android.R;
import com.uele.reidx.android.TestComponentRule;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.RuleChain;
import org.junit.rules.TestRule;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withHint;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
public class LoginEspressoTest {

    public final TestComponentRule component =
            new TestComponentRule(InstrumentationRegistry.getTargetContext());

    public final IntentsTestRule<LoginActivity> main =
            new IntentsTestRule<>(LoginActivity.class, false, false);

    @Rule
    public TestRule chain = RuleChain.outerRule(component).around(main);

    @Before
    public void setup() {

    }

    @Test
    public void checkViewsDisplay() {
        main.launchActivity(LoginActivity.getStartIntent(component.getContext()));

        onView(withId(R.id.loginEmailEdt))
                .check(matches(isDisplayed()));

        onView(withId(R.id.loginPasswordEdt))
                .check(matches(isDisplayed()));

        onView(withId(R.id.loginBtn))
                .check(matches(isDisplayed()));

        onView(withText(R.string.button_login))
                .check(matches(isDisplayed()));
    }

    @Test
    public void testViewElements() throws PackageManager.NameNotFoundException {
        main.launchActivity(LoginActivity.getStartIntent(component.getContext()));
        onView(withId(R.id.loginEmailEdt)).check(matches(withHint(R.string.hint_email)));
        onView(withId(R.id.loginPasswordEdt)).check(matches(withHint(R.string.hint_password)));
        onView(withId(R.id.loginBtn)).check(matches(withText(R.string.button_login)));
        onView(withId(R.id.tvForgotPassword)).
                check(matches(withText(R.string.textview_forgot_password)));
    }

    @Test
    public void testLoginButton() {
        main.launchActivity(LoginActivity.getStartIntent(component.getContext()));
        onView(withId(R.id.loginEmailEdt)).perform(typeText("brian@ca.ibm.com"));
        onView(withId(R.id.loginPasswordEdt)).perform(typeText("8)6%&21"));
        onView(withId(R.id.loginBtn)).perform(click());
    }
}