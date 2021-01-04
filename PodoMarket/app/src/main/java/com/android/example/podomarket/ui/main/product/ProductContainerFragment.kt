package com.android.example.podomarket.ui.main.product

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.android.example.podomarket.R
import com.android.example.podomarket.databinding.FragmentProductContainerBinding

class ProductContainerFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding: FragmentProductContainerBinding by lazy {
            DataBindingUtil.inflate(inflater, R.layout.fragment_product_container, container, false)
                    as FragmentProductContainerBinding
        }
        return binding.root
    }

}