package com.android.example.podomarket.ui.search.after

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.android.example.podomarket.ui.search.after.AfterSearchPageConst.PRODUCT
import com.android.example.podomarket.ui.search.after.AfterSearchPageConst.USER

class AfterSearchPagerAdapter(activity: FragmentActivity) : FragmentStateAdapter(activity) {
    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            PRODUCT -> AfterSearchProductFragment()
            USER -> AfterSearchUserFragment()
            else -> {
                throw Error("Not valid fragment for designated page number.")
            }
        }
    }
}

object AfterSearchPageConst {
    const val PRODUCT = 0
    const val USER = 1
}