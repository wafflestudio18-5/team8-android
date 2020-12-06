package com.android.example.podomarket.ui.main.product

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
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

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.search_button -> Toast.makeText(activity, "Search", Toast.LENGTH_SHORT).show()
            R.id.category_button -> findNavController().navigate(R.id.action_productListFragment_to_productCategoryFragment)
            R.id.alert_button -> findNavController().navigate(R.id.action_productListFragment_to_inboxFragment)
            else -> throw Error("Not valid menu item for in toolbar.")
        }
        return super.onOptionsItemSelected(item)
    }
}