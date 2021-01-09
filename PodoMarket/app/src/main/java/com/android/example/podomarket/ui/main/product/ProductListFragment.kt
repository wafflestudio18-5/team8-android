package com.android.example.podomarket.ui.main.product

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.android.example.podomarket.R
import com.android.example.podomarket.databinding.FragmentProductListBinding
import com.android.example.podomarket.ui.product.create.ProductCreateActivity
import com.android.example.podomarket.ui.product.detail.ProductDetailActivity
import com.android.example.podomarket.ui.search.SearchActivity
import org.koin.android.viewmodel.ext.android.sharedViewModel


class ProductListFragment : Fragment() {

    private val productViewModel: ProductViewModel by sharedViewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding: FragmentProductListBinding by lazy {
            DataBindingUtil.inflate(inflater, R.layout.fragment_product_list, container, false)
        }
        binding.run {
            toolBar.also { tb ->
                tb.inflateMenu(R.menu.app_bar_fragment_product_list)
                tb.setOnMenuItemClickListener {
                    when (it.itemId) {
                        R.id.search_button -> startActivity(SearchActivity.intent(requireContext()))
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
            lifecycleOwner = this@ProductListFragment
            viewModel = productViewModel
            adapter = ProductListAdapter {
                startActivity(ProductDetailActivity.intentWithProductId(it.id, requireContext()))
            }
        }
        return binding.root
    }
}