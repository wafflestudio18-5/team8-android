package com.android.example.podomarket.ui.product

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.android.example.podomarket.R
import com.android.example.podomarket.databinding.ActivityMainBinding
import com.android.example.podomarket.databinding.ActivityProductDetailBinding

class ProductDetailActivity : AppCompatActivity() {
    private val binding: ActivityProductDetailBinding by lazy {
        DataBindingUtil.setContentView(
            this,
            R.layout.activity_product_detail
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.run {
            toolBar.also { tb ->
                tb.inflateMenu(R.menu.app_bar_activity_product_detail)
                tb.setNavigationIcon(R.drawable.ic_baseline_arrow_back_24)
                tb.setNavigationOnClickListener { finish() }
                tb.setOnMenuItemClickListener {
                    when(it.itemId) {
                        R.id.share_button -> Toast.makeText(applicationContext, "공유 기능 미완성", Toast.LENGTH_SHORT)
                        R.id.more_button -> Toast.makeText(applicationContext, "추가 기능 미완성", Toast.LENGTH_SHORT)
                        else -> return@setOnMenuItemClickListener false
                    }
                    return@setOnMenuItemClickListener true
                }
            }
        }
    }
}