package com.android.example.podomarket.ui.main.product

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.android.example.podomarket.R
import com.android.example.podomarket.databinding.FragmentProductListBinding
import com.android.example.podomarket.ui.product.create.ProductCreateActivity


class ProductListFragment : Fragment() {

    lateinit var binding: FragmentProductListBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_product_list, container, false)

        binding.run {
            toolBar.also { tb ->
                tb.inflateMenu(R.menu.app_bar_fragment_product_list)
                tb.setOnMenuItemClickListener {
                    when (it.itemId) {
                        R.id.search_button -> Toast.makeText(activity, "Search", Toast.LENGTH_SHORT)
                            .show()
                        R.id.category_button -> findNavController().navigate(R.id.action_productListFragment_to_productCategoryFragment)
                        R.id.alert_button -> findNavController().navigate(R.id.action_productListFragment_to_inboxFragment)
                        else -> return@setOnMenuItemClickListener false
                    }
                    return@setOnMenuItemClickListener true
                }
            }
            addProductFab.setOnClickListener {
                startActivity(ProductCreateActivity.intent(requireContext()))
            }
        }
        return binding.root
    }
}