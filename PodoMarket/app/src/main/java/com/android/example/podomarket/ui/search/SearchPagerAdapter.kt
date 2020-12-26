package com.android.example.podomarket.ui.search

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class SearchPagerAdapter(activity: FragmentActivity) : FragmentStateAdapter(activity) {
    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            
            else -> {
                throw Error("Not valid fragment for designated page number.")
            }
        }
    }
}

object SearchPageConst {
    const val BEFORE_SEARCH = 0
    const val AFTER_SEARCH = 1
}