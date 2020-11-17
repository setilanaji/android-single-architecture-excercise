package com.ydh.androidsinglearchitecture

import android.util.Patterns

class Email(private val email: String) {
    val isValidEmail: Boolean
        get() = validateEmail()

    private fun validateEmail(): Boolean {
        return email.isNotEmpty() && validateEmailFormat()
    }

    private fun validateEmailFormat(): Boolean {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }
}