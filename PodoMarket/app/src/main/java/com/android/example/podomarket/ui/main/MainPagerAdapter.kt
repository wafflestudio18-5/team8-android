package com.android.example.podomarket.ui.main

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.android.example.podomarket.ui.main.MainPageConst.ARTICLE
import com.android.example.podomarket.ui.main.MainPageConst.CHAT
import com.android.example.podomarket.ui.main.MainPageConst.MYPAGE
import com.android.example.podomarket.ui.main.MainPageConst.PRODUCT

class MainPagerAdapter(activity: FragmentActivity) : FragmentStateAdapter(activity) {
    override fun getItemCount(): Int = 4

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            PRODUCT -> ProductContainerFragment()
            ARTICLE -> ArticleFragment()
            CHAT -> ChatRoomListFragment()
            MYPAGE -> MyPageContainerFragment()
            else -> {
                throw Error("Not valid fragment for designated page number.")
            }
        }
    }
}

object MainPageConst {
    const val PRODUCT = 0
    const val ARTICLE = 1
    const val CHAT = 2
    const val MYPAGE = 3
}