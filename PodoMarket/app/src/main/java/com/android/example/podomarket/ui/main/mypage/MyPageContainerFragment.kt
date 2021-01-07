package com.android.example.podomarket.ui.main.mypage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.android.example.podomarket.R
import com.android.example.podomarket.databinding.FragmentMyPageContainerBinding
import org.koin.android.viewmodel.ext.android.viewModel

class MyPageContainerFragment : Fragment() {

    val myPageViewModel: MyPageViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding: FragmentMyPageContainerBinding by lazy {
            DataBindingUtil.inflate(inflater, R.layout.fragment_my_page_container, container, false)
                    as FragmentMyPageContainerBinding
        }
        return binding.root
    }

}