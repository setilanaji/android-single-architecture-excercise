package com.ydh.androidsinglearchitecture

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.util.SparseArray
import android.view.View
import androidx.core.util.forEach
import androidx.core.util.set
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.ydh.androidsinglearchitecture.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val prefs: UserSession by lazy {
        UserSession(App.instance)
    }
    lateinit var bottomNavigation: BottomNavigationView
    lateinit var binding: ActivityMainBinding
    private lateinit var appBarConfiguration : AppBarConfiguration
    private lateinit var navigationController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        navigationController = this.findNavController(R.id.myNavHostFragment)

        setNavigation()
        if (!prefs.loggedIn){
            navigationController.navigate(R.id.loginFragment)
        }
    }

    private fun setNavigation(){
        bottomNavigation = binding.navigationBottom
        NavigationUI.setupWithNavController(bottomNavigation, navigationController )
        NavigationUI.setupActionBarWithNavController(this, navigationController )
        appBarConfiguration = AppBarConfiguration(navigationController.graph)
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = this.findNavController(R.id.myNavHostFragment)
        return NavigationUI.navigateUp(navController, appBarConfiguration)
    }

}