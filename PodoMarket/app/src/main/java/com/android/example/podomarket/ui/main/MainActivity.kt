package com.android.example.podomarket.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.android.example.podomarket.R
import com.android.example.podomarket.databinding.ActivityMainBinding
import com.android.example.podomarket.ui.main.MainPageType.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.run {
            pager.adapter = MainPagerAdapter(this@MainActivity)
            pager.isUserInputEnabled = false
            bottomNavigation.setOnNavigationItemSelectedListener {
                when (it.itemId) {
                    R.id.product_fragment -> pager.setCurrentItem(PRODUCT.value, false)
                    R.id.article_fragment -> pager.setCurrentItem(ARTICLE.value, false)
                    R.id.chat_room_list_fragment -> pager.setCurrentItem(CHAT.value, false)
                    R.id.my_page_fragment -> pager.setCurrentItem(MYPAGE.value, false)
                    else -> {
                        error("Invalid itemId in bottomNavigation")
                    }
                }
                true
            }
        }
    }
}