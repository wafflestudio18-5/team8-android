package com.android.example.podomarket.ui.product

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.android.example.podomarket.ui.product.ProductUserSellPageConst.HIDDEN_PRODUCT
import com.android.example.podomarket.ui.product.ProductUserSellPageConst.SELLING_PRODUCT
import com.android.example.podomarket.ui.product.ProductUserSellPageConst.SOLD_PRODUCT

class ProductUserSellPagerAdapter(activity: FragmentActivity) : FragmentStateAdapter(activity) {
    override fun getItemCount(): Int = 3

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            SELLING_PRODUCT -> SellingProductFragment()
            SOLD_PRODUCT -> SoldProductFragment()
            HIDDEN_PRODUCT -> HiddenProductFragment()
            else -> {
                throw Error("Not valid fragment for designated page number.")
            }
        }
    }
}

object ProductUserSellPageConst {
    const val SELLING_PRODUCT = 0
    const val SOLD_PRODUCT = 1
    const val HIDDEN_PRODUCT = 2
}