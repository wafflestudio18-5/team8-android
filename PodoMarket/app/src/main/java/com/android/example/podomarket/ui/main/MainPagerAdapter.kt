package com.android.example.podomarket.ui.main

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.android.example.podomarket.ui.main.MainPageType.*
import com.android.example.podomarket.ui.main.MainPageType.Companion.getByValue

class MainPagerAdapter(activity: FragmentActivity) : FragmentStateAdapter(activity) {
    override fun getItemCount(): Int = 4

    override fun createFragment(position: Int): Fragment {
        return when (getByValue(position)) {
            PRODUCT -> ProductFragment()
            ARTICLE -> ArticleFragment()
            CHAT -> ChatRoomListFragment()
            MYPAGE -> MyPageFragment()
        }
    }
}

enum class MainPageType(val value: Int) {
    PRODUCT(0),
    ARTICLE(1),
    CHAT(2),
    MYPAGE(3);

    companion object {
        private val VALUES = values();
        fun getByValue(value: Int) = VALUES.first { it.value == value }
    }
}