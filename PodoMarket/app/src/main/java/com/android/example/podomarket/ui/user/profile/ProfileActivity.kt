package com.android.example.podomarket.ui.user.profile

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

                val userId: Int = intent.getIntExtra("user_id", 0)

                if (userId == 0) { // my profile

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

                    myProfileEditButton.visibility = View.GONE
                    otherProfileFollowButton.visibility = View.VISIBLE

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
                                "추가 기능 미완성",
                                Toast.LENGTH_SHORT
                            ).show()
                            else -> return@setOnMenuItemClickListener false
                        }
                        return@setOnMenuItemClickListener true
                    }

                }
            }

            myProfileEditButton.setOnClickListener {
                startActivity(UserInfoEditActivity.intent(this@ProfileActivity))
            }
            otherProfileFollowButton.setOnClickListener {
                Toast.makeText(
                    this@ProfileActivity,
                    "모아보기 기능 미완성",
                    Toast.LENGTH_SHORT
                ).show()
            }
            temperatureInfoButton.setOnClickListener {
                Toast.makeText(
                    this@ProfileActivity,
                    R.string.temperature_description,
                    Toast.LENGTH_SHORT
                ).show()
            }
            productUserSellButton.setOnClickListener {
                //startActivity(ProductUserSellActivity.intentWithUserId(profileViewModel.userId))
            }
        }
    }

    companion object {
        private const val USER_ID = "user_id"

        fun intentWithUserId(user_id: Int, context: Context): Intent =
            Intent(context, ProfileActivity::class.java).apply { putExtra(USER_ID, user_id) }
    }
}