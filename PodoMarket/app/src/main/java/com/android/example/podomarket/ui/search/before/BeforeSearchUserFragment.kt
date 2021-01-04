package com.android.example.podomarket.ui.search.before

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.android.example.podomarket.R
import com.android.example.podomarket.databinding.FragmentBeforeSearchUserBinding

class BeforeSearchUserFragment : Fragment() {

    lateinit var binding: FragmentBeforeSearchUserBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_before_search_user, container, false)
        return binding.root
    }

}