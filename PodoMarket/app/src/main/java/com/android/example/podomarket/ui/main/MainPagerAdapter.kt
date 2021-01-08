package com.android.example.podomarket.ui.main

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.android.example.podomarket.ui.main.MainPageConst.CHAT
import com.android.example.podomarket.ui.main.MainPageConst.MYPAGE
import com.android.example.podomarket.ui.main.MainPageConst.PRODUCT
import com.android.example.podomarket.ui.main.chat.ChatRoomListFragment
import com.android.example.podomarket.ui.main.mypage.MyPageContainerFragment
import com.android.example.podomarket.ui.main.product.ProductContainerFragment

class MainPagerAdapter(activity: FragmentActivity) : FragmentStateAdapter(activity) {
    override fun getItemCount(): Int = 3

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            PRODUCT -> ProductContainerFragment()
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
    const val CHAT = 1
    const val MYPAGE = 2
}