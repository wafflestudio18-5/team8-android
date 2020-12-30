package com.android.example.podomarket.ui.user

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.android.example.podomarket.R
import com.android.example.podomarket.databinding.ActivityUserInterestedBinding
import com.google.android.material.tabs.TabLayoutMediator

class UserInterestedActivity : AppCompatActivity() {

    private val binding: ActivityUserInterestedBinding by lazy {
        DataBindingUtil.setContentView(
            this,
            R.layout.activity_user_interested
        ) as ActivityUserInterestedBinding
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val tabLayoutTextIdArray = arrayOf(R.string.used_trading)

        binding.run {
            pager.adapter = UserInterestedPagerAdapter(this@UserInterestedActivity)
            pager.isUserInputEnabled = true
            TabLayoutMediator(tabLayout, pager) { tab, position ->
                tab.text = getString(tabLayoutTextIdArray[position])
            }.attach()
            toolBar.also { tb ->
                tb.setNavigationIcon(R.drawable.ic_baseline_arrow_back_24)
                tb.setNavigationOnClickListener { finish() }
            }
        }
    }

    companion object {
        fun intent(context: Context): Intent = Intent(context, UserInterestedActivity::class.java)
    }
}