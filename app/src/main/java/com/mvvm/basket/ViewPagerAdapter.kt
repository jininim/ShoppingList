package com.mvvm.basket

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.mvvm.basket.ui.list.TabOneFragment
import com.mvvm.basket.ui.TabThreeFragment
import com.mvvm.basket.ui.TabTwoFragment

class ViewPagerAdapter(fragmentActivity: FragmentActivity, i: Int): FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        return if (position == 0) {
            TabOneFragment()
        } else if (position == 1) {
            TabTwoFragment()
        } else {
            TabThreeFragment()
        }
    }
}

