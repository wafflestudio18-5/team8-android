package com.android.example.podomarket.ui.search

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.android.example.podomarket.R
import com.android.example.podomarket.databinding.ActivityMainBinding
import com.android.example.podomarket.databinding.ActivitySearchBinding

class SearchActivity : AppCompatActivity() {
    private val binding: ActivitySearchBinding by lazy {
        DataBindingUtil.setContentView(
            this,
            R.layout.activity_search
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.run {
            
        }
    }
}