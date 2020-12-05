package com.android.example.podomarket.ui.user

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.android.example.podomarket.R
import androidx.databinding.DataBindingUtil
import com.android.example.podomarket.databinding.ActivityProfileBinding

class ProfileActivity : AppCompatActivity() {
    private val binding: ActivityProfileBinding by lazy {
        DataBindingUtil.setContentView(
            this,
            R.layout.activity_profile
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.run {

        }
    }
}