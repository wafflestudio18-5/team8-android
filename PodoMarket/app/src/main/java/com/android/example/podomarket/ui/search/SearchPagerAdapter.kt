package com.android.example.podomarket.ui.search

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class SearchPagerAdapter(activity: FragmentActivity) : FragmentStateAdapter(activity) {
    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            SearchPageConst.PRODUCT -> SearchProductFragment()
            SearchPageConst.USER -> SearchUserFragment()
            else -> {
                throw Error("Not valid fragment for designated page number.")
            }
        }
    }
}

object SearchPageConst {
    const val PRODUCT = 0
    const val USER = 1
}