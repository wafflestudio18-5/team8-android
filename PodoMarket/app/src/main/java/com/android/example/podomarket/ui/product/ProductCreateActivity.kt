package com.android.example.podomarket.ui.product

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.android.example.podomarket.R
import com.android.example.podomarket.databinding.ActivityMainBinding
import com.android.example.podomarket.databinding.ActivityProductCreateBinding

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

        }
    }
}