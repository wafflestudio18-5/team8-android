package com.android.example.podomarket.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.android.example.podomarket.R
import com.android.example.podomarket.databinding.ActivityMainBinding
import com.android.example.podomarket.ui.main.MainPageConst.ARTICLE
import com.android.example.podomarket.ui.main.MainPageConst.CHAT
import com.android.example.podomarket.ui.main.MainPageConst.MYPAGE
import com.android.example.podomarket.ui.main.MainPageConst.PRODUCT

class MainActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding by lazy {
        DataBindingUtil.setContentView(
            this,
            R.layout.activity_main
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.run {
            pager.adapter = MainPagerAdapter(this@MainActivity)
            pager.isUserInputEnabled = false
            bottomNavigation.setOnNavigationItemSelectedListener {
                when (it.itemId) {
                    R.id.product_fragment -> pager.setCurrentItem(PRODUCT, false)
                    R.id.article_fragment -> pager.setCurrentItem(ARTICLE, false)
                    R.id.chat_room_list_fragment -> pager.setCurrentItem(CHAT, false)
                    R.id.my_page_fragment -> pager.setCurrentItem(MYPAGE, false)
                    else -> {
                        error("Invalid itemId in bottomNavigation")
                    }
                }
                true
            }
        }
    }
}