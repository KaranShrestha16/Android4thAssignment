package com.example.android4thassignment;

import androidx.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.Espresso.closeSoftKeyboard;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

public class checkUserTest {

    @Rule
    public ActivityTestRule<Login> testRule=
            new ActivityTestRule<>(Login.class);
    private String mText="Hello";

    @Test
    public void TestUI() throws Exception{
        onView(withId(R.id.etUserName))
                .perform(typeText(mText));

        closeSoftKeyboard();

        onView(withId(R.id.btnLogin))
                .perform(click());

        onView(withId(R.id.tvRegister))
                .check(matches(withText(mText)));
    }

}
