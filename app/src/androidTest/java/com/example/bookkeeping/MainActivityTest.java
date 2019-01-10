package com.example.bookkeeping;

import android.support.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.closeSoftKeyboard;
import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.Espresso.pressBack;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.anything;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void onCreate() throws InterruptedException {
        onView(withId(R.id.crt_account_but)).perform(click());
        onView(withId(R.id.crt_name_account)).perform(typeText("TestAcc1"));
        onView(withId(R.id.crt_desc_account)).perform(typeText("this is test"));
        onView(withId(R.id.crt_balance_account)).perform(typeText("100000"));
        onView(withId(R.id.crt_account_but_go)).perform(click());

        onView(withId(R.id.crt_account_but)).perform(click());
        onView(withId(R.id.crt_name_account)).perform(typeText("TestAcc2"));
        onView(withId(R.id.crt_desc_account)).perform(typeText("this is test"));
        onView(withId(R.id.crt_balance_account)).perform(typeText("45000"));
        onView(withId(R.id.crt_account_but_go)).perform(click());

        onData(anything()).inAdapterView(withId(R.id.listView)).atPosition(0).perform(click());

        onView(withId(R.id.crt_oper_but)).perform(click());

        onView(withId(R.id.crt_oper_desc)).perform(typeText("desc..."));
        closeSoftKeyboard();
        onView(withId(R.id.account_on)).perform(click());
        onData(allOf(is(instanceOf(String.class)), is("TestAcc2"))).perform(click());
        onView(withId(R.id.bablo)).perform(typeText("200"));
        closeSoftKeyboard();
        onView(withId(R.id.crt_oper_type)).perform(click());
        onData(allOf(is(instanceOf(String.class)), is("transfer"))).perform(click());
        onView(withId(R.id.crt_oper_category)).perform(click());
        onData(allOf(is(instanceOf(String.class)), is("profitable"))).perform(click());
        onView(withId(R.id.crt_oper_but_go)).perform(click());

        onData(anything()).inAdapterView(withId(R.id.listView)).atPosition(0).perform(click());

        Thread.sleep(200);
        onView(withId(R.id.delete_oper_but)).perform(click());
        onView(withId(R.id.delete_acc_but)).perform(click());

    }
}