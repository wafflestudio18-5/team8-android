package com.android.example.podomarket.ui.main.product

import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.android.example.podomarket.R
import com.android.example.podomarket.databinding.FragmentProductListBinding


class ProductListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding: FragmentProductListBinding by lazy {
            DataBindingUtil.inflate(inflater, R.layout.fragment_product_list, container, false)
        }
        binding.run {
            (activity as AppCompatActivity).setSupportActionBar(toolBar)
            setHasOptionsMenu(true)
        }
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.app_bar_fragment_product_list, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }
}