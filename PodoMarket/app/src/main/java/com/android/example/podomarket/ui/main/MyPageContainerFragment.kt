package com.android.example.podomarket.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.android.example.podomarket.R
import com.android.example.podomarket.databinding.FragmentMyPageContainerBinding

class MyPageContainerFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding: FragmentMyPageContainerBinding by lazy {
            DataBindingUtil.inflate(inflater, R.layout.fragment_my_page_container, container, false)
        }
        return binding.root
    }

}