package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.adapter.ViewPagerAdapter
import com.example.myapplication.databinding.ActivityViewPagerBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class ViewPagerActivity : AppCompatActivity() {

    private lateinit var binding: ActivityViewPagerBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityViewPagerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val pagerAdapter = ViewPagerAdapter(supportFragmentManager, lifecycle)
        binding.viewPager.adapter = pagerAdapter

        TabLayoutMediator(binding.tabs,binding.viewPager){ tabs, position ->
            tabs.text = "Page ${position+1}"
        }.attach()


    }
}