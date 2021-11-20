package com.example.elozino_task_5

import androidx.test.espresso.Espresso.*
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    /**
     * Test for visibility of the main activity layout and views attached to it
     **/
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

    /** Test to show the actions of the register button */
    @Test
    fun changeText_newActivity() {
        onView(withId(R.id.et_name)).perform(typeText(CORRECT_NAME_INPUT), ViewActions.closeSoftKeyboard())
        onView(withId(R.id.et_phone)).perform(typeText(CORRECT_PHONE_NUMBER_INPUT), ViewActions.closeSoftKeyboard())
        onView(withId(R.id.et_email)).perform(typeText(CORRECT_EMAIL_INPUT), ViewActions.closeSoftKeyboard())
        onView(withId(R.id.sex_drop_down)).perform(
            replaceText("Male")
        )
        ViewActions.closeSoftKeyboard()
        onView(withId(R.id.button_register)).perform(click())

        onView(withId(R.id.name_content)).check(matches(withText(CORRECT_NAME_INPUT)))
        onView(withId(R.id.phone_content)).check(matches(withText(CORRECT_PHONE_NUMBER_INPUT)))
        onView(withId(R.id.email_content)).check(matches(withText(CORRECT_EMAIL_INPUT)))
        onView(withId(R.id.sex_content)).check(matches(withText("Male")))

    }

    companion object {
        const val CORRECT_NAME_INPUT = "Danny Young"
        const val CORRECT_PHONE_NUMBER_INPUT = "08035019076"
        const val CORRECT_EMAIL_INPUT = "ghost@ymail.io"
        const val INCORRECT_NAME_INPUT = "3John"
        const val INCORRECT_PHONE_NUMBER_INPUT = "2347193421384"
        const val INCORRECT_EMAIL_INPUT = ".ghost@gmail.c"
    }
}