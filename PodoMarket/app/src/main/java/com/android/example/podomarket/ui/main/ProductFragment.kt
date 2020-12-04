package com.android.example.podomarket.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.android.example.podomarket.R
import com.android.example.podomarket.databinding.FragmentProductBinding

class ProductFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding: FragmentProductBinding by lazy {
            DataBindingUtil.inflate(inflater, R.layout.fragment_product, container, false)
        }
        return binding.root
    }

}