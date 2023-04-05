package com.mvvm.basket

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.google.android.material.tabs.TabLayoutMediator


import com.mvvm.basket.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        binding.activity = this

        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)

        //ViewPager2와 Adapter
        val adapter = ViewPagerAdapter(this)
        binding.Viewpager2.adapter = adapter

        TabLayoutMediator(binding.TabLayout,binding.Viewpager2){
            tab , position ->
            when(position){
                0 -> {
                    tab.text = "구매 목록"
                }
            }
        }.attach()


    }
}