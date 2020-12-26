package com.android.example.podomarket.ui.product

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.android.example.podomarket.ui.product.ProductUserSellPageConst.MY_SALES
import com.android.example.podomarket.ui.product.ProductUserSellPageConst.OTHER_SALES

class ProductUserSellPagerAdapter(activity: FragmentActivity) : FragmentStateAdapter(activity) {
    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            MY_SALES -> MySalesListFragment()
            OTHER_SALES -> OtherSalesListFragment()
            else -> {
                throw Error("Not valid fragment for designated page number.")
            }
        }
    }
}

object ProductUserSellPageConst {
    const val MY_SALES = 0
    const val OTHER_SALES = 1
}