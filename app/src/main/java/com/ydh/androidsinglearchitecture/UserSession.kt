package com.ydh.androidsinglearchitecture

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit

class UserSession(private val context: Context){
    companion object{
        const val SHARED_NAME = "com.ydh.singlearch"

        const val LOGGED_KEY = "LOGGED_KEY"
    }

    private val prefs: SharedPreferences by lazy{
        context.getSharedPreferences(SHARED_NAME, Context.MODE_PRIVATE)
    }

    var loggedIn : Boolean
        get() = prefs.getBoolean(LOGGED_KEY, false)
        set(value) = prefs.edit { putBoolean(LOGGED_KEY, value) }
}