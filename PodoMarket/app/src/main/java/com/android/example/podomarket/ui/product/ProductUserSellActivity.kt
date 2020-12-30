package com.android.example.podomarket.ui.product

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.android.example.podomarket.R
import com.android.example.podomarket.databinding.ActivityProductUserSellBinding
import com.android.example.podomarket.ui.main.MainPageConst
import com.google.android.material.tabs.TabLayoutMediator

class ProductUserSellActivity : AppCompatActivity() {

    private var userId: Long = 0L
    private val binding: ActivityProductUserSellBinding by lazy {
        DataBindingUtil.setContentView(
            this,
            R.layout.activity_product_user_sell
        ) as ActivityProductUserSellBinding
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (intent.hasExtra("user_id")) {
            userId = intent.getLongExtra("user_id", 0L)
        }

        binding.run {
            pager.adapter = ProductUserSellPagerAdapter(this@ProductUserSellActivity)
            pager.isUserInputEnabled = false
            when (userId) {
                0L -> pager.setCurrentItem(ProductUserSellPageConst.MY_SALES, false)
                else -> pager.setCurrentItem(ProductUserSellPageConst.OTHER_SALES, false)
            }
        }
    }

    companion object {
        fun intentWithUserId(userId: Long, context: Context): Intent
                = Intent(context, ProductUserBuyActivity::class.java).apply { putExtra("user_id", userId) }
    }
}