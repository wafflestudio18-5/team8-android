package com.android.example.podomarket.ui.product.sell

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.android.example.podomarket.ui.product.sell.OtherSalesListPageConst.ALL_PRODUCT
import com.android.example.podomarket.ui.product.sell.OtherSalesListPageConst.SELLING_PRODUCT
import com.android.example.podomarket.ui.product.sell.OtherSalesListPageConst.SOLD_PRODUCT

class OtherSalesListPagerAdapter(activity: FragmentActivity) : FragmentStateAdapter(activity) {
    override fun getItemCount(): Int = 3

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            ALL_PRODUCT -> AllProductFragment()
            SELLING_PRODUCT -> SellingProductFragment()
            SOLD_PRODUCT -> SoldProductFragment()
            else -> {
                throw Error("Not valid fragment for designated page number.")
            }
        }
    }
}

object OtherSalesListPageConst {
    const val ALL_PRODUCT = 0
    const val SELLING_PRODUCT = 1
    const val SOLD_PRODUCT = 2
}