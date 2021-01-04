package com.android.example.podomarket.ui.search.before

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.android.example.podomarket.R
import com.android.example.podomarket.databinding.FragmentBeforeSearchBinding
import com.google.android.material.tabs.TabLayoutMediator

class BeforeSearchFragment : Fragment() {

    lateinit var binding: FragmentBeforeSearchBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val tabLayoutTextIdArray = arrayOf(R.string.used_trading, R.string.human)

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_before_search, container, false)
        binding.run {
            pager.adapter = BeforeSearchPagerAdapter(requireActivity())
            pager.isUserInputEnabled = true
            TabLayoutMediator(tabLayout, pager) { tab, position ->
                tab.text = getString(tabLayoutTextIdArray[position])
            }.attach()
        }
        return binding.root
    }

}