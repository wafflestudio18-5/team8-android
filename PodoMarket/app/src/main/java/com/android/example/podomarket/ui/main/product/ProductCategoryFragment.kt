package com.android.example.podomarket.ui.main.product

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.android.example.podomarket.R
import com.android.example.podomarket.databinding.FragmentProductCategoryBinding
import org.koin.android.viewmodel.ext.android.sharedViewModel

class ProductCategoryFragment : Fragment() {

    private val productViewModel: ProductViewModel by sharedViewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding: FragmentProductCategoryBinding by lazy {
            DataBindingUtil.inflate(inflater, R.layout.fragment_product_category, container, false)
                    as FragmentProductCategoryBinding
        }
        binding.run {
            toolBar.also { tb ->
                tb.setNavigationIcon(R.drawable.ic_baseline_arrow_back_24)
                tb.setNavigationOnClickListener {
                    findNavController().navigateUp()
                }
            }
        }
        return binding.root
    }


}