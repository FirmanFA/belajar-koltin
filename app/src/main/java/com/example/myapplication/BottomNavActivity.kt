package com.example.myapplication

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.myapplication.databinding.ActivityBottomNavBinding
import com.example.myapplication.fragment.PageDuaFragment
import com.example.myapplication.fragment.PageSatuFragment

class BottomNavActivity : AppCompatActivity() {

    private lateinit var binding: ActivityBottomNavBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityBottomNavBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView

        navView.setOnItemSelectedListener {
            when(it.itemId){
                R.id.satu -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragmentContainerView, PageSatuFragment())
                        .commit()
                    true
                }
                R.id.dua ->{
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragmentContainerView, PageDuaFragment())
                        .commit()
                    true
                }
                else -> true
            }
        }

    }
}