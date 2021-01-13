package com.example.qrcodescanner

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : AppCompatActivity() {
    var bottomNavigationView: BottomNavigationView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
            setUpNavigation()
        }

        fun setUpNavigation() {
            bottomNavigationView = findViewById(R.id.bottomNavigationView)
            val navHostFragment = supportFragmentManager
                .findFragmentById(R.id.nav_host_frag) as NavHostFragment?
            NavigationUI.setupWithNavController(
                bottomNavigationView!!,
                navHostFragment?.navController!!
            )
        }
    }
