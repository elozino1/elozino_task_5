package com.example.elozino_task_5

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun is_main_activity_layout_visible() {
        onView(withId(R.id.main_activity_layout)).check(matches(isDisplayed()))
    }

    @Test
    fun isRegisterTextViewVisible() {
        onView(withId(R.id.tv_register)).check(matches(isDisplayed()))
    }

    @Test
    fun isNameTextInputLayoutVisible() {
        onView(withId(R.id.tl_name)).check(matches(isDisplayed()))
    }

    @Test
    fun isNameTextInputEditTextVisible() {
        onView(withId(R.id.et_name)).check(matches(isDisplayed()))
    }

    @Test
    fun isPhoneNumberTextInputLayoutVisible() {
        onView(withId(R.id.tl_phone_number)).check(matches(isDisplayed()))
    }

    @Test
    fun isPhoneNumberTextInputEditTextVisible() {
        onView(withId(R.id.et_phone)).check(matches(isDisplayed()))
    }

    @Test
    fun isEmailTextInputLayoutVisible() {
        onView(withId(R.id.tl_email)).check(matches(isDisplayed()))
    }

    @Test
    fun isEmailTextInputEditTextVisible() {
        onView(withId(R.id.et_email)).check(matches(isDisplayed()))
    }

    @Test
    fun isSexTextInputLayoutVisible() {
        onView(withId(R.id.tl_sex)).check(matches(isDisplayed()))
    }

    @Test
    fun isSexAutoCompleteDropDownVisible() {
        onView(withId(R.id.sex_drop_down)).check(matches(isDisplayed()))
    }

    @Test
    fun isRegisterButtonVisible() {
        onView(withId(R.id.button_register)).check(matches(isDisplayed()))
    }
}