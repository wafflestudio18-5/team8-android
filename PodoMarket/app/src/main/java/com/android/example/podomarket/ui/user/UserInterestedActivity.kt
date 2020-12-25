package com.android.example.podomarket.ui.user

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.android.example.podomarket.R
import com.android.example.podomarket.databinding.ActivityUserInterestedBinding

class UserInterestedActivity : AppCompatActivity() {
    private val binding: ActivityUserInterestedBinding by lazy {
        DataBindingUtil.setContentView(
            this,
            R.layout.activity_user_interested
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.run {

        }
    }
}