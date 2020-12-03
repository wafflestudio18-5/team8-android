package com.android.example.podomarket.ui.main

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.android.example.podomarket.ui.main.FragmentConst.ARTICLE
import com.android.example.podomarket.ui.main.FragmentConst.CHAT
import com.android.example.podomarket.ui.main.FragmentConst.MYPAGE
import com.android.example.podomarket.ui.main.FragmentConst.PRODUCT

class MainPagerAdapter(activity: FragmentActivity) : FragmentStateAdapter(activity) {
    override fun getItemCount(): Int = 4

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            PRODUCT -> ProductFragment()
            ARTICLE -> ArticleFragment()
            CHAT -> ChatRoomListFragment()
            MYPAGE -> MyPageFragment()
            else -> {
                throw Error("Not valid fragment for designated page number.")
            }
        }
    }
}

object FragmentConst {
    const val PRODUCT = 0
    const val ARTICLE = 1
    const val CHAT = 2
    const val MYPAGE = 3
}