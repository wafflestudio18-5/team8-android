package com.android.example.podomarket.ui.main.product

import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.android.example.podomarket.R
import com.android.example.podomarket.databinding.FragmentProductCategoryBinding


class ProductCategoryFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding: FragmentProductCategoryBinding by lazy {
            DataBindingUtil.inflate(inflater, R.layout.fragment_product_category, container, false)
        }
        binding.run {
            (activity as AppCompatActivity).setSupportActionBar(toolBar)
            (activity as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true)
            (activity as AppCompatActivity).supportActionBar?.setDisplayShowHomeEnabled(true)
            setHasOptionsMenu(true)
        }
        return binding.root
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> findNavController().navigateUp()
            else -> throw Error("Not valid menu item for in toolbar.")
        }
        return super.onOptionsItemSelected(item)
    }
}