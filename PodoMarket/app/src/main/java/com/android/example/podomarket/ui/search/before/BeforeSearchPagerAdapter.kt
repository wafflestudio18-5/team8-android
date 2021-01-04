package com.android.example.podomarket.ui.search.before

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.android.example.podomarket.ui.search.before.BeforeSearchPageConst.PRODUCT
import com.android.example.podomarket.ui.search.before.BeforeSearchPageConst.USER

class BeforeSearchPagerAdapter(activity: FragmentActivity) : FragmentStateAdapter(activity) {
    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            PRODUCT -> BeforeSearchProductFragment()
            USER -> BeforeSearchUserFragment()
            else -> {
                throw Error("Not valid fragment for designated page number.")
            }
        }
    }
}

object BeforeSearchPageConst {
    const val PRODUCT = 0
    const val USER = 1
}