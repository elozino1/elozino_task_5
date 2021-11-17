package com.example.elozino_task_5.util

class ValidatorUtil {
    companion object {
        fun isEmailValid(emailInput: String) : Boolean {
            val pattern = Regex("^\\w+([\\.-]?\\w+)*@\\w+([\\.-]?\\w+)*(\\.\\w{2,3})+$")
            return emailInput.isNotBlank() && emailInput.matches(pattern)
        }

        fun isSexEntryValid(sexInput: String) : Boolean{
            return sexInput.isNotBlank()
        }

        fun isPhoneNumberValid(phoneNumberInput: String) : Boolean {
            val pattern = Regex("^(234|0)(8([01])|(9([01]))|([7])([0]))\\d{8}$")
            return phoneNumberInput.isNotBlank() && phoneNumberInput.matches(pattern)
        }

        fun isNameValid(name: String) : Boolean {
            val pattern = Regex("\\b([A-ZÀ-ÿ][-,a-z. ']+[ ]*)+")
            return name.isNotBlank() && name.matches(pattern)
        }
    }
}