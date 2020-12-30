package com.android.example.podomarket.ui.user

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.android.example.podomarket.R
import com.android.example.podomarket.databinding.ActivityUserInfoEditBinding

class UserInfoEditActivity : AppCompatActivity() {

    private val binding: ActivityUserInfoEditBinding by lazy {
        DataBindingUtil.setContentView(
            this,
            R.layout.activity_user_info_edit
        ) as ActivityUserInfoEditBinding
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_info_edit)
    }

    companion object {
        fun intent(context: Context): Intent = Intent(context, UserInfoEditActivity::class.java)
    }
}