package com.android.example.podomarket.ui.product

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.android.example.podomarket.R
import com.android.example.podomarket.databinding.ActivityProductDetailBinding
import com.android.example.podomarket.ui.chat.ChatRoomActivity
import com.android.example.podomarket.ui.user.ProfileActivity

class ProductDetailActivity : AppCompatActivity() {

    private val binding: ActivityProductDetailBinding by lazy {
        DataBindingUtil.setContentView(
            this,
            R.layout.activity_product_detail
        ) as ActivityProductDetailBinding
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.run {
            toolBar.also { tb ->
                tb.inflateMenu(R.menu.app_bar_activity_product_detail)
                tb.setNavigationIcon(R.drawable.ic_baseline_arrow_back_24)
                tb.setNavigationOnClickListener { finish() }
                tb.setOnMenuItemClickListener {
                    when (it.itemId) {
                        R.id.share_button -> Toast.makeText(
                            this@ProductDetailActivity,
                            "공유 기능 미완성",
                            Toast.LENGTH_SHORT
                        ).show()
                        R.id.more_button -> Toast.makeText(
                            this@ProductDetailActivity,
                            "추가 기능 미완성",
                            Toast.LENGTH_SHORT
                        ).show()
                        else -> return@setOnMenuItemClickListener false
                    }
                    return@setOnMenuItemClickListener true
                }
            }
            userInfoLayout.setOnClickListener {
                //startActivity(ProfileActivity.intentWithUserId(productDetailViewModel.userId, this@ProductDetailActivity))
            }
            moreButton.setOnClickListener {
                Toast.makeText(
                    this@ProductDetailActivity,
                    "더보 기능(미완성)",
                    Toast.LENGTH_SHORT
                ).show()
            }
            likeButton.setOnClickListener {
                /*
                productDetailViewModel.isLikeOn = !productDetailViewModel.isLikeOn

                if (productDetailViewModel.isLikeOn) {
                    likeButton.setColorFilter(R.color.purple_500)
                } else {
                    likeButton.setColorFilter(R.color.dark_gray)
                }
                */
            }
            callButton.setOnClickListener {
                Toast.makeText(
                    this@ProductDetailActivity,
                    "전화하기 기능(미완성)",
                    Toast.LENGTH_SHORT
                ).show()
            }
            chatButton.setOnClickListener {
                //startActivity(ChatRoomActivity.intentWithChatRoomId(productDetailViewModel.chatRoomId))
            }
        }
    }

    companion object {
        private const val PRODUCT_ID = "product_id"

        fun intentWithProductId(product_id: Long, context: Context): Intent =
            Intent(context, ProductDetailActivity::class.java).apply {
                putExtra(
                    PRODUCT_ID,
                    product_id
                )
            }
    }
}