package com.android.example.podomarket.ui.product

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.android.example.podomarket.R
import com.android.example.podomarket.databinding.ActivityMainBinding
import com.android.example.podomarket.databinding.ActivityProductCreateBinding
import com.android.example.podomarket.ui.user.ProfileActivity

class ProductCreateActivity : AppCompatActivity() {

    private val binding: ActivityProductCreateBinding by lazy {
        DataBindingUtil.setContentView(
            this,
            R.layout.activity_product_create
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.run {
            toolBar.also { tb ->
                tb.inflateMenu(R.menu.app_bar_activity_product_create)
                tb.setNavigationIcon(R.drawable.ic_baseline_arrow_back_24)
                tb.setNavigationOnClickListener { finish() }
                tb.setOnMenuItemClickListener {
                    when(it.itemId) {
                        R.id.complete_button -> Toast.makeText(applicationContext, "상품 등록 완료(미완성)", Toast.LENGTH_SHORT)
                        else -> return@setOnMenuItemClickListener false
                    }
                    return@setOnMenuItemClickListener true
                }
            }
        }
    }

    companion object {
        fun intent(context: Context): Intent = Intent(context, ProductCreateActivity::class.java)
    }
}