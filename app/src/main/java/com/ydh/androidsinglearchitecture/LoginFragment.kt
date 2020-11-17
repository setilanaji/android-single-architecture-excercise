package com.ydh.androidsinglearchitecture

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.textfield.TextInputLayout
import com.ydh.androidsinglearchitecture.databinding.FragmentLoginBinding
import kotlinx.android.synthetic.main.activity_main.*


class LoginFragment : Fragment() {
    lateinit var binding: FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_login,container, false)

        setView()
        setListener()

        return binding.root
    }

    private fun setView(){
        (activity as AppCompatActivity).supportActionBar?.hide()
        (activity as AppCompatActivity).navigationBottom.visibility = View.GONE
    }

    private fun setListener(){
        binding.etLoginEmail.addTextChangedListener(emailListener)
        binding.etLoginPassword.addTextChangedListener(passwordListener)
        binding.buttonLogin.setOnClickListener(buttonLoginListener)
        binding.buttonToRegister.setOnClickListener(buttonToRegisterListener)
    }

    private val buttonLoginListener = View.OnClickListener {

        it.findNavController().navigate(R.id.action_loginFragment_to_homeFragment2)
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





}