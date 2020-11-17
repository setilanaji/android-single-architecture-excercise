package com.ydh.androidsinglearchitecture

import android.os.Binder
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.ydh.androidsinglearchitecture.databinding.FragmentHomeBinding
import kotlinx.android.synthetic.main.activity_main.*


class HomeFragment : Fragment() {

    lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
        setView()
        
        return binding.root
    }

    private fun setView(){
        (activity as AppCompatActivity).supportActionBar?.show()
        (activity as AppCompatActivity).navigationBottom.visibility = View.VISIBLE
    }


}