package com.android.example.podomarket.ui.product

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.android.example.podomarket.R
import com.android.example.podomarket.databinding.ActivitySelectCategoryBinding
import com.android.example.podomarket.databinding.ActivitySelectCityBinding

class SelectCityActivity : AppCompatActivity() {

    private val binding: ActivitySelectCityBinding by lazy {
        DataBindingUtil.setContentView(
            this,
            R.layout.activity_select_city
        ) as ActivitySelectCityBinding
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.run {

        }
    }

    companion object {
        fun intent(context: Context): Intent = Intent(context, SelectCityActivity::class.java)
    }
}