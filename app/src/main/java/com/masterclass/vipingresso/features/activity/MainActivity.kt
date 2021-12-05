package com.masterclass.vipingresso.features.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI.setupWithNavController
import com.masterclass.vipingresso.R
import com.masterclass.vipingresso.databinding.ActivityMainBinding
import com.masterclass.vipingresso.features.home.view.HomeFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val navController = Navigation.findNavController(this,R.id.nav_host_fragment)
        setupWithNavController(binding.bottomNavigation,navController)

        val fragment = HomeFragment()
        supportFragmentManager.beginTransaction()
            .replace(binding.container.id, fragment)
            .addToBackStack(null).commit()
    }
}