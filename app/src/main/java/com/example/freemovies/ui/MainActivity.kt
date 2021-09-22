package com.example.freemovies.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.freemovies.R
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


       val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigation)
       val  navHostFragment =
         supportFragmentManager.findFragmentById(R.id.fragment)

       val  navController = navHostFragment?.findNavController()

        val appBarConfiguration = AppBarConfiguration(setOf(
            R.id.homeFragment,
            R.id.favoriteFragment,
            R.id.userFragment
        ))
        if (navController != null) {
            setupActionBarWithNavController(navController, appBarConfiguration)

            bottomNavigationView.setupWithNavController(navController)

    }
    }

    /*override fun onCreateOptionsMenu(menu: Menu?): Boolean {
    val inflater :MenuInflater = menuInflater
        inflater.inflate(R.menu.refresh,menu)
        return true
    }*/
}