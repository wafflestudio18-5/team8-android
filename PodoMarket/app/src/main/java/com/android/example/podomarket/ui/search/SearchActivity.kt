package com.android.example.podomarket.ui.search

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.android.example.podomarket.R
import com.android.example.podomarket.databinding.ActivitySearchBinding
import com.google.android.material.tabs.TabLayoutMediator

class SearchActivity : AppCompatActivity() {
    companion object {
        fun intent(context: Context): Intent = Intent(context, SearchActivity::class.java)
    }

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