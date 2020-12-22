package com.android.example.podomarket.ui.user

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.android.example.podomarket.R
import androidx.databinding.DataBindingUtil
import com.android.example.podomarket.databinding.ActivityProfileBinding

class ProfileActivity : AppCompatActivity() {
    companion object {
        fun intent(context: Context): Intent = Intent(context, ProfileActivity::class.java)
    }

    private val binding: ActivityProfileBinding by lazy {
        DataBindingUtil.setContentView(
            this,
            R.layout.activity_profile
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.run {
            toolBar.also { tb ->
                tb.inflateMenu(R.menu.app_bar_activity_profile)
                tb.setOnMenuItemClickListener {
                    when(it.itemId) {
                        R.id.navigate_up_button -> finish()
                        R.id.share_button -> Toast.makeText(applicationContext, "공유하기 기능 미완성", Toast.LENGTH_SHORT)
                        else -> return@setOnMenuItemClickListener false
                    }
                    return@setOnMenuItemClickListener true
                }
            }
        }
    }

}