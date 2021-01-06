package com.android.example.podomarket.ui.search

import android.content.Context
import android.content.Intent
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

    companion object {
        private const val CATEGORY_ID = "category_id"

        fun intentWithCategoryId(category_id: Long, context: Context): Intent =
            Intent(context, ProductByCategoryActivity::class.java).apply {
                putExtra(
                    CATEGORY_ID,
                    category_id
                )
            }
    }
}