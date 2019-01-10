package com.example.bookkeeping;

import android.support.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.closeSoftKeyboard;
import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;

public class CreateOperActivityTest {

    @Rule
    public ActivityTestRule<CreateOperActivity> mActivityTestRule = new ActivityTestRule<>(CreateOperActivity.class);

    @Test
    public void onCreate() {
        onView(withId(R.id.crt_oper_desc))
                .perform(typeText("desc..."));
        closeSoftKeyboard();
        onView(withId(R.id.bablo))
                .perform(typeText("200"));
        closeSoftKeyboard();
        onView(withId(R.id.crt_oper_type)).perform(click());
        onData(allOf(is(instanceOf(String.class)), is("transfer"))).perform(click());
        onView(withId(R.id.crt_oper_category)).perform(click());
        onData(allOf(is(instanceOf(String.class)), is("profitable"))).perform(click());
        onView(withId(R.id.crt_oper_but_go))
                .perform(click());
    }
}