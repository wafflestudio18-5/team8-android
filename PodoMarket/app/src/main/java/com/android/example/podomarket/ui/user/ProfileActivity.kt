package com.android.example.podomarket.ui.user

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.android.example.podomarket.R
import com.android.example.podomarket.databinding.ActivityProfileBinding

class ProfileActivity : AppCompatActivity() {

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

                val userId: Long = intent.getLongExtra("user_id", 0L)

                if (userId == 0L) { // my profile

                    tb.inflateMenu(R.menu.app_bar_activity_profile)
                    tb.setOnMenuItemClickListener {
                        when (it.itemId) {
                            R.id.share_button -> Toast.makeText(
                                this@ProfileActivity,
                                "공유하기 기능 미완성",
                                Toast.LENGTH_SHORT
                            ).show()
                            else -> return@setOnMenuItemClickListener false
                        }
                        return@setOnMenuItemClickListener true
                    }

                } else { // other profile

                    myProfileEditBtn.visibility = View.GONE
                    otherProfileFollowBtn.visibility = View.VISIBLE

                    tb.inflateMenu(R.menu.app_bar_activity_profile_other)
                    tb.setOnMenuItemClickListener {
                        when (it.itemId) {
                            R.id.share_button -> Toast.makeText(
                                this@ProfileActivity,
                                "공유하기 기능 미완성",
                                Toast.LENGTH_SHORT
                            ).show()
                            R.id.more_button -> Toast.makeText(
                                this@ProfileActivity,
                                "추 기능 미완성",
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

    companion object {
        fun intentWithUserId(context: Context, user_id: Long): Intent // 자기 자신이면 user_id로 0을 전달
            = Intent(context, ProfileActivity::class.java).apply { putExtra("user_id", user_id) }

    }
}