package com.android.example.podomarket.ui.user.interested

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.android.example.podomarket.ui.user.interested.UserInterestedPageConst.ARTICLE
import com.android.example.podomarket.ui.user.interested.UserInterestedPageConst.PRODUCT

class UserInterestedPagerAdapter(activity: FragmentActivity) : FragmentStateAdapter(activity) {
    override fun getItemCount(): Int = 1

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            PRODUCT -> UserInterestedProductFragment()
            ARTICLE -> {
                throw Error("UserInterestedArticleFragment 미완성")
            }
            else -> {
                throw Error("Not valid fragment for designated page number.")
            }
        }
    }
}

object UserInterestedPageConst {
    const val PRODUCT = 0
    const val ARTICLE = 1
}