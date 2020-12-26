package com.android.example.podomarket.ui.product

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.android.example.podomarket.R
import com.android.example.podomarket.databinding.FragmentOtherSalesListBinding

class OtherSalesListFragment : Fragment() {

    lateinit var binding: FragmentOtherSalesListBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_other_sales_list, container, false)
        binding.run {

        }
        return binding.root
    }

}