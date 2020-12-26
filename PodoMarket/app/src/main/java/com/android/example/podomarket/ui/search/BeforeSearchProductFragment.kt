package com.android.example.podomarket.ui.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.android.example.podomarket.R
import com.android.example.podomarket.databinding.FragmentBeforeSearchProductBinding

class BeforeSearchProductFragment : Fragment() {

    lateinit var binding: FragmentBeforeSearchProductBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_before_search_product, container, false)
        binding.run {

        }
        return binding.root
    }

}