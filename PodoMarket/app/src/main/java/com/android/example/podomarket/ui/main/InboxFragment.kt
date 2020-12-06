package com.android.example.podomarket.ui.main

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.android.example.podomarket.R
import com.android.example.podomarket.databinding.FragmentInboxBinding


class InboxFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding: FragmentInboxBinding by lazy {
            DataBindingUtil.inflate(inflater, R.layout.fragment_inbox, container, false)
        }
        binding.run {
            (activity as AppCompatActivity).setSupportActionBar(toolBar)
            (activity as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true)
            (activity as AppCompatActivity).supportActionBar?.setDisplayShowHomeEnabled(true)
            setHasOptionsMenu(true)
        }
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.app_bar_fragment_inbox, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.edit_button -> Toast.makeText(activity, "Edit", Toast.LENGTH_SHORT).show()
            R.id.delete_button -> Toast.makeText(activity, "Delete", Toast.LENGTH_SHORT).show()
            android.R.id.home -> findNavController().navigateUp()
            else -> throw Error("Not valid menu item for in toolbar.")
        }
        return super.onOptionsItemSelected(item)
    }

}