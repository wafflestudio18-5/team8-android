package com.android.example.podomarket.ui.search

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.android.example.podomarket.ui.search.SearchPageConst.AFTER_SEARCH
import com.android.example.podomarket.ui.search.SearchPageConst.BEFORE_SEARCH

class SearchPagerAdapter(activity: FragmentActivity) : FragmentStateAdapter(activity) {
    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            BEFORE_SEARCH -> BeforeSearchFragment()
            AFTER_SEARCH -> AfterSearchFragment()
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