package com.android.example.podomarket.ui.product

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.android.example.podomarket.R
import com.android.example.podomarket.databinding.FragmentMySalesListBinding
import com.google.android.material.tabs.TabLayoutMediator

class MySalesListFragment : Fragment() {

    lateinit var binding: FragmentMySalesListBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val tabLayoutTextIdArray = arrayOf(R.string.selling, R.string.sold_out, R.string.hidden)

        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_my_sales_list, container, false)
        binding.run {
            pager.adapter = MySalesListPagerAdapter(requireActivity()) // 주의
            pager.isUserInputEnabled = true
            TabLayoutMediator(tabLayout, pager) { tab, position ->
                tab.text = getString(tabLayoutTextIdArray[position])
            }.attach()
            toolBar.also { tb ->
                tb.setNavigationIcon(R.drawable.ic_baseline_arrow_back_24)
                tb.setNavigationOnClickListener { activity?.finish() }
            }
        }
        return binding.root
    }

}