package com.android.example.podomarket.ui.search

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.android.example.podomarket.R
import com.android.example.podomarket.databinding.ActivityProductByCategoryBinding

class ProductByCategoryActivity : AppCompatActivity() {

    private val binding: ActivityProductByCategoryBinding by lazy {
        DataBindingUtil.setContentView(
            this,
            R.layout.activity_product_by_category
        ) as ActivityProductByCategoryBinding
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