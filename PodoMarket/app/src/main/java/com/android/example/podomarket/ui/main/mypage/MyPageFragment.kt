package com.android.example.podomarket.ui.main.mypage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.android.example.podomarket.R
import com.android.example.podomarket.databinding.FragmentMyPageBinding


class MyPageFragment : Fragment() {


    lateinit var binding: FragmentMyPageBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_my_page, container, false)
        binding.run {
            toolBar.also { tb ->
                tb.inflateMenu(R.menu.app_bar_fragment_my_page)
                tb.setOnMenuItemClickListener {
                    when (it.itemId) {
                        R.id.setting_button -> findNavController().navigate(R.id.action_myPageFragment_to_settingFragment)
                        else -> return@setOnMenuItemClickListener false
                    }
                    return@setOnMenuItemClickListener true
                }
            }
            clickListener = MyPageItemClickListener {
                when (it.id) {
                    R.id.set_current_place_item -> Toast.makeText(
                        activity,
                        "SET CURRENT PLACE ITEM",
                        Toast.LENGTH_SHORT
                    ).show()
                    R.id.key_word_alert_item -> Toast.makeText(
                        activity,
                        "KEY WORD ALERT ITEM",
                        Toast.LENGTH_SHORT
                    ).show()
                    R.id.setting_item -> findNavController().navigate(R.id.action_myPageFragment_to_settingFragment)
                }
            }
        }
        return binding.root
    }

}

class MyPageItemClickListener(val clickListener: (item: View) -> Unit) {
    fun onClick(item: View) = clickListener(item)
}