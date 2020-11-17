package com.ydh.androidsinglearchitecture

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity

class ProfileFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        setView()

        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    private fun setView(){
        (activity as AppCompatActivity).supportActionBar?.hide()

    }

}