package com.android.example.podomarket.ui.main.chat

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.example.podomarket.R
import com.android.example.podomarket.databinding.FragmentChatRoomListBinding
import org.koin.android.viewmodel.ext.android.viewModel


class ChatRoomListFragment : Fragment() {

    lateinit var binding: FragmentChatRoomListBinding
    private val chatRoomListViewModel: ChatRoomListViewModel by viewModel()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_chat_room_list, container, false)
        binding.run {
            viewModel = chatRoomListViewModel
            lifecycleOwner = this@ChatRoomListFragment
            chatListView.adapter = ChatRoomListAdapter()
            chatListView.layoutManager = LinearLayoutManager(requireContext())
        }

        return binding.root
    }

    override fun onResume() {
        chatRoomListViewModel.getChatRooms()
        super.onResume()
    }

    override fun onPause() {
        chatRoomListViewModel.clearChatRooms()
        super.onPause()
    }

}
