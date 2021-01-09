package com.android.example.podomarket.ui.product.detail

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.android.example.podomarket.R
import com.android.example.podomarket.databinding.ActivityProductDetailBinding
import com.android.example.podomarket.ui.chat.ChatRoomActivity
import com.android.example.podomarket.ui.product.sell.ProductUserSellActivity
import com.android.example.podomarket.ui.user.profile.ProfileActivity
import org.koin.android.viewmodel.ext.android.viewModel

class ProductDetailActivity : AppCompatActivity() {

    private val binding: ActivityProductDetailBinding by lazy {
        DataBindingUtil.setContentView(
            this,
            R.layout.activity_product_detail
        ) as ActivityProductDetailBinding
    }
    private val productDetailViewModel: ProductDetailViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val productId = intent.getIntExtra(ProductDetailActivity.PRODUCT_ID, -1)
        productDetailViewModel.apply {
            getProductById(productId)
        }
        binding.run {
            lifecycleOwner = this@ProductDetailActivity
            viewModel = productDetailViewModel
            toolBar.also { tb ->
                tb.setNavigationIcon(R.drawable.ic_baseline_arrow_back_24)
                tb.setNavigationOnClickListener { finish() }
                tb.inflateMenu(R.menu.app_bar_activity_product_detail)
                tb.setOnMenuItemClickListener {
                    when (it.itemId) {
                        R.id.share_button -> Toast.makeText(
                            this@ProductDetailActivity,
                            "Share",
                            Toast.LENGTH_SHORT
                        ).show()
                        R.id.more_button -> Toast.makeText(
                            this@ProductDetailActivity,
                            "More",
                            Toast.LENGTH_SHORT
                        ).show()
                        else -> return@setOnMenuItemClickListener false
                    }
                    return@setOnMenuItemClickListener true
                }
            }
            userInfoLayout.setOnClickListener {
                val product = productDetailViewModel.theProduct.value
                startActivity(product?.seller?.let { userId -> ProfileActivity.intentWithUserId(userId, this@ProductDetailActivity) })
            }
            moreButton.setOnClickListener {
                val product = productDetailViewModel.theProduct.value
                startActivity(product?.seller?.let { userId -> ProductUserSellActivity.intentWithUserId(userId, this@ProductDetailActivity) })
            }
            likeButton.setOnClickListener {
                productDetailViewModel.putLikeProduct(productId, it as ImageView)
            }
            chatButton.setOnClickListener {
                val product = productDetailViewModel.theProduct.value
                startActivity(product?.seller?.let { userId -> ChatRoomActivity.intentWithProductIdAndUserId(productId, userId, this@ProductDetailActivity) })
            }
        }
    }

    companion object {
        private const val PRODUCT_ID = "product_id"

        fun intentWithProductId(product_id: Int, context: Context): Intent =
            Intent(context, ProductDetailActivity::class.java).apply {
                putExtra(
                    PRODUCT_ID,
                    product_id
                )
            }
    }
}