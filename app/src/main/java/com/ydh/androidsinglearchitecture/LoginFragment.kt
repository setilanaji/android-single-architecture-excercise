package com.ydh.androidsinglearchitecture

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.textfield.TextInputLayout
import com.ydh.androidsinglearchitecture.databinding.FragmentLoginBinding
import kotlinx.android.synthetic.main.activity_main.*


class LoginFragment : Fragment() {
    lateinit var binding: FragmentLoginBinding
    lateinit var loginViewModel: LoginViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_login,container, false)

        setView()
        setViewModel()
        setListener()
        setObserver()

        return binding.root
    }

    private fun setObserver(){
        loginViewModel.apply {
            isEmailValid.observe(viewLifecycleOwner, isValidEmailObserver)
            isPasswordValid.observe(viewLifecycleOwner, isValidPasswordObserver)
            isLogged.observe(viewLifecycleOwner, isLoggedObserver)
        }
     }

    private fun setViewModel(){
        loginViewModel =  ViewModelProviders.of(this).get(LoginViewModel::class.java)
    }

    private fun setView(){
        (activity as AppCompatActivity).supportActionBar?.hide()
        (activity as AppCompatActivity).navigationBottom.visibility = View.GONE
    }

    private fun setListener(){
        binding.apply {
            etLoginEmail.addTextChangedListener(emailListener)
            etLoginPassword.addTextChangedListener(passwordListener)
            buttonLogin.setOnClickListener(buttonLoginListener)
            buttonToRegister.setOnClickListener(buttonToRegisterListener)
        }
    }

    private val buttonLoginListener = View.OnClickListener {
        loginViewModel.completedForm( binding.etLoginPassword.text.toString(), binding.etLoginEmail.text.toString())
    }

    private val buttonToRegisterListener = View.OnClickListener {
        it.findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
    }

    private val emailListener = object: TextWatcher{
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

        }

        override fun afterTextChanged(s: Editable?) {
        }

    }

    private val passwordListener = object : TextWatcher {
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        }

        override fun afterTextChanged(s: Editable?) {
        }
    }

    private val isValidEmailObserver = Observer<Boolean> { TODO("Not yet implemented") }

    private val isValidPasswordObserver = Observer<Boolean> { TODO("Not yet implemented") }

    private val isLoggedObserver =
        Observer<LoginViewModel.RegisteredState> { t ->
            when(t){
                LoginViewModel.RegisteredState.LOGGED -> {
                    Toast.makeText(requireContext(), "Login is succes", Toast.LENGTH_LONG).show()
                    this.findNavController().navigate(R.id.homeFragment)
                }
                LoginViewModel.RegisteredState.UNLOGGED -> Toast.makeText(requireContext(), "Login is un succeed", Toast.LENGTH_LONG).show()
            }
        }




}