package com.android.example.podomarket.ui.user

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.android.example.podomarket.R
import com.android.example.podomarket.databinding.ActivityProfileBinding

class ProfileActivity : AppCompatActivity() {
    companion object {
        fun intent(context: Context): Intent = Intent(context, ProfileActivity::class.java)
    }

    private val binding: ActivityProfileBinding by lazy {
        DataBindingUtil.setContentView(
            this,
            R.layout.activity_profile
        ) as ActivityProfileBinding
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.run {
            toolBar.also { tb ->
                tb.setNavigationIcon(R.drawable.ic_baseline_arrow_back_24)
                tb.setNavigationOnClickListener { finish() }
                tb.inflateMenu(R.menu.app_bar_activity_profile)
                tb.setOnMenuItemClickListener {
                    when (it.itemId) {
                        R.id.share_button -> Toast.makeText(
                            applicationContext,
                            "공유하기 기능 미완성",
                            Toast.LENGTH_SHORT
                        ).show()
                        else -> return@setOnMenuItemClickListener false
                    }
                    return@setOnMenuItemClickListener true
                }
            }
        }
    }

}