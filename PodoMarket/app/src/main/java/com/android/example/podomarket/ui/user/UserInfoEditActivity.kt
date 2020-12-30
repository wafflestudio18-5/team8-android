package com.android.example.podomarket.ui.user

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
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

        binding.run {
            toolBar.also { tb ->
                tb.setNavigationIcon(R.drawable.ic_baseline_arrow_back_24)
                tb.setNavigationOnClickListener { finish() }
                tb.inflateMenu(R.menu.app_bar_activity_user_info_edit)
                tb.setOnMenuItemClickListener {
                    when (it.itemId) {
                        R.id.complete_button -> {
                            Toast.makeText(
                                applicationContext,
                                "프로필 수정 기능 미완성",
                                Toast.LENGTH_SHORT
                            ).show()
                            finish()
                        }
                        else -> return@setOnMenuItemClickListener false
                    }
                    return@setOnMenuItemClickListener true
                }
            }
        }
    }

    companion object {
        fun intent(context: Context): Intent = Intent(context, UserInfoEditActivity::class.java)
    }
}