package com.ydh.androidsinglearchitecture

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class LoginViewModel(application: Application) : AndroidViewModel(application){

    private val prefs: UserSession by lazy {
        UserSession(App.instance)
    }
//    private lateinit var password: Password
//    lateinit var email:Email

    enum class RegisteredState {
        LOGGED, UNLOGGED
    }

    private val _isEmailValid: MutableLiveData<Boolean> by lazy {
        MutableLiveData<Boolean>()
    }
    private val _isPasswordValid: MutableLiveData<Boolean> by lazy {
        MutableLiveData<Boolean>()
    }
    private val _isLogged: MutableLiveData<RegisteredState> by lazy {
        MutableLiveData<RegisteredState>()
    }

    init {
        _isLogged.value = RegisteredState.UNLOGGED
    }


    val isLogged: LiveData<RegisteredState>
        get() = _isLogged

    val isPasswordValid: LiveData<Boolean>
        get() = _isPasswordValid

    val isEmailValid: LiveData<Boolean>
        get() = _isEmailValid

    fun completedForm(passwordEntered: String, emailEntered: String) {
        val email = Email(emailEntered)
        val password = Password(passwordEntered)
        println("${email.isValidEmail}")
        println("${password.isValidPassword}")
        if (password.isValidPassword && email.isValidEmail) {
            _isLogged.value = RegisteredState.LOGGED
            prefs.loggedIn = true
        }
    }
}