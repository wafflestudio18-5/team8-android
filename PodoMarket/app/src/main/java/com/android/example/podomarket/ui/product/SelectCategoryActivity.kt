package com.android.example.podomarket.ui.product

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.android.example.podomarket.R
import com.android.example.podomarket.databinding.ActivitySelectCategoryBinding

class SelectCategoryActivity : AppCompatActivity() {

    private val binding: ActivitySelectCategoryBinding by lazy {
        DataBindingUtil.setContentView(
            this,
            R.layout.activity_select_category
        ) as ActivitySelectCategoryBinding
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
        fun intent(context: Context): Intent = Intent(context, SelectCategoryActivity::class.java)
    }
}