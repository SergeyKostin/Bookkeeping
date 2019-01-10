package com.example.bookkeeping;

import android.support.test.rule.ActivityTestRule;

import com.example.bookkeeping.model.Controller;

import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.anything;
import static org.hamcrest.Matchers.hasToString;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.startsWith;
import static org.junit.Assert.*;

public class CreateAccountActivityTest {
    @Rule
    public ActivityTestRule<CreateAccountActivity> mActivityTestRule = new ActivityTestRule<>(CreateAccountActivity.class);

    @Test
    public void onCreate() {
        int num = Controller.listAccounts.size();
        onView(withId(R.id.crt_name_account))
                .perform(typeText("TestName"));
        onView(withId(R.id.crt_desc_account))
                .perform(typeText("this is test"));
        onView(withId(R.id.crt_balance_account))
                .perform(typeText("10000"));
        onView(withId(R.id.crt_account_but_go))
                .perform(click());
        assertEquals(num + 1, Controller.listAccounts.size());
        assertEquals(Controller.listAccounts.get(num).getName(),"TestName");
        assertEquals(Controller.listAccounts.get(num).getDescription(),"this is test");
        assertEquals(String.valueOf(Controller.listAccounts.get(num).getBalance()),"10000");

        onData(anything()).inAdapterView(withId(R.id.listView)).atPosition(0).perform(click());
    }
}