package com.example.elozino_task_5.util

import org.junit.Assert
import org.junit.Test

class ValidatorUtilTest {

    @Test
    fun `email is not valid returns false`() {
        Assert.assertFalse(ValidatorUtil.isEmailValid(".@ght.io"))
    }

    @Test
    fun `email is valid returns true`() {
        Assert.assertTrue(ValidatorUtil.isEmailValid("fd@ght.io"))
    }

    @Test
    fun `email is empty returns false`() {
        Assert.assertFalse(ValidatorUtil.isEmailValid(""))
    }

    @Test
    fun `phone number is valid returns true`() {
        Assert.assertTrue(ValidatorUtil.isPhoneNumberValid("2348152345678"))
    }

    @Test
    fun `phone number is empty returns false`() {
        Assert.assertFalse(ValidatorUtil.isPhoneNumberValid(""))
    }

    @Test
    fun `phone number is not valid returns false`() {
        Assert.assertFalse(ValidatorUtil.isPhoneNumberValid("2340152345678"))
    }

    @Test
    fun `is sex entry empty`() {
        Assert.assertFalse(ValidatorUtil.isSexEntryValid(""))
    }

    @Test
    fun `name is valid returns true`() {
        Assert.assertTrue(ValidatorUtil.isNameValid("Asah Zino"))
    }

    @Test
    fun `name is invalid returns false`() {
        Assert.assertFalse(ValidatorUtil.isNameValid("2Asah Zino"))
    }

    @Test
    fun `name is empty returns false`() {
        Assert.assertFalse(ValidatorUtil.isNameValid(""))
    }
}