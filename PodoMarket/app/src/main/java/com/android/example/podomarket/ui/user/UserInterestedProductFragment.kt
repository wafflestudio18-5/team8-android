package com.android.example.podomarket.ui.user

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.android.example.podomarket.R
import com.android.example.podomarket.databinding.FragmentUserInterestedProductBinding

class UserInterestedProductFragment : Fragment() {

    lateinit var binding: FragmentUserInterestedProductBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_user_interested_product, container, false)

        return binding.root
    }

}