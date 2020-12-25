package com.android.example.podomarket.ui.product

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.android.example.podomarket.R
import com.android.example.podomarket.databinding.ActivityProductUserSellBinding
import com.google.android.material.tabs.TabLayoutMediator

class ProductUserSellActivity : AppCompatActivity() {
    companion object {
        fun intent(context: Context): Intent = Intent(context, ProductUserBuyActivity::class.java)
    }

    private val binding: ActivityProductUserSellBinding by lazy {
        DataBindingUtil.setContentView(
            this,
            R.layout.activity_product_user_sell
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val tabLayoutTextIdArray = arrayOf(R.string.selling, R.string.sold_out, R.string.hidden)

        binding.run {
            pager.adapter = ProductUserSellPagerAdapter(this@ProductUserSellActivity)
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
}