package com.android.example.podomarket.ui.product

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.android.example.podomarket.ui.product.MySalesListPageConst.HIDDEN_PRODUCT
import com.android.example.podomarket.ui.product.MySalesListPageConst.SELLING_PRODUCT
import com.android.example.podomarket.ui.product.MySalesListPageConst.SOLD_PRODUCT

class MySalesListPagerAdapter(activity: FragmentActivity) : FragmentStateAdapter(activity) {
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

object MySalesListPageConst {
    const val SELLING_PRODUCT = 0
    const val SOLD_PRODUCT = 1
    const val HIDDEN_PRODUCT = 2
}