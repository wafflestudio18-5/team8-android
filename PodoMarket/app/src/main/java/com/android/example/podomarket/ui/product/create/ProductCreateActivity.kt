package com.android.example.podomarket.ui.product.create

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.android.example.podomarket.AppConstants
import com.android.example.podomarket.R
import com.android.example.podomarket.databinding.ActivityProductCreateBinding
import org.koin.android.viewmodel.ext.android.viewModel

class ProductCreateActivity : AppCompatActivity() {

    private val binding: ActivityProductCreateBinding by lazy {
        DataBindingUtil.setContentView(
            this,
            R.layout.activity_product_create
        ) as ActivityProductCreateBinding
    }
    private val productCreateViewModel: ProductCreateViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.run {
            toolBar.also { tb ->
                tb.inflateMenu(R.menu.app_bar_activity_product_create)
                tb.setNavigationIcon(R.drawable.ic_baseline_arrow_back_24)
                tb.setNavigationOnClickListener { finish() }
                tb.setOnMenuItemClickListener {
                    when(it.itemId) {
                        R.id.complete_button ->
                            productCreateViewModel
                                .postProduct(productName.text.toString(),productPrice.text.toString().toInt())
                        else -> return@setOnMenuItemClickListener false
                    }
                    return@setOnMenuItemClickListener true
                }
            }
            cameraButton.setOnClickListener {
                Toast.makeText(
                    this@ProductCreateActivity,
                    "사진 추가 기능(미완성)",
                    Toast.LENGTH_SHORT
                ).show()
            }
            selectCategoryButton.setOnClickListener {
                startActivityForResult(SelectCategoryActivity.intent(this@ProductCreateActivity), AppConstants.SELECT_CATEGORY_ACTIVITY)
            }
            priceOfferButton.setOnClickListener {
                productCreateViewModel.toggleAllowSuggest(it as ImageView)
            }
            selectCityButton.setOnClickListener {
                startActivityForResult(SelectCityActivity.intent(this@ProductCreateActivity), AppConstants.SELECT_CITY_ACTIVITY)
            }
        }
    }

    companion object {
        fun intent(context: Context): Intent = Intent(context, ProductCreateActivity::class.java)
    }
}