package com.android.example.podomarket.ui.product

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.android.example.podomarket.R
import com.android.example.podomarket.databinding.ActivityProductUserBuyBinding

class ProductUserBuyActivity : AppCompatActivity() {
    private val binding: ActivityProductUserBuyBinding by lazy {
        DataBindingUtil.setContentView(
            this,
            R.layout.activity_product_user_buy
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.run {
            toolBar.also { tb ->
                tb.setNavigationIcon(R.drawable.ic_baseline_arrow_back_24)
                tb.setNavigationOnClickListener { finish() }
            }
        }
    }
}