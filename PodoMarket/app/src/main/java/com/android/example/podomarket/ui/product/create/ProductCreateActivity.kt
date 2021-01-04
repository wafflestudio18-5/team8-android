package com.android.example.podomarket.ui.product.create

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.android.example.podomarket.R
import com.android.example.podomarket.databinding.ActivityProductCreateBinding

class ProductCreateActivity : AppCompatActivity() {

    private val binding: ActivityProductCreateBinding by lazy {
        DataBindingUtil.setContentView(
            this,
            R.layout.activity_product_create
        ) as ActivityProductCreateBinding
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.run {
            toolBar.also { tb ->
                tb.inflateMenu(R.menu.app_bar_activity_product_create)
                tb.setNavigationIcon(R.drawable.ic_baseline_arrow_back_24)
                tb.setNavigationOnClickListener { finish() }
                tb.setOnMenuItemClickListener {
                    when(it.itemId) {
                        R.id.complete_button -> Toast.makeText(
                            this@ProductCreateActivity,
                            "상품 등록 완료(미완성)",
                            Toast.LENGTH_SHORT
                        ).show()
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
                startActivity(SelectCategoryActivity.intent(this@ProductCreateActivity))
            }
            priceOfferButton.setOnClickListener {
                /*
                productCreateViewModel.isPriceOfferOn = !productCreateViewModel.isPriceOfferOn

                if (productCreateViewModel.isPriceOfferOn) {
                    imgPriceOffer.setImageResource(R.drawable.ic_baseline_check_circle_24)
                } else {
                    imgPriceOffer.setImageResource(R.drawable.ic_baseline_check_circle_outline_24)
                }
                */
            }
            selectCityButton.setOnClickListener {
                startActivity(SelectCityActivity.intent(this@ProductCreateActivity))
            }
        }
    }

    companion object {
        fun intent(context: Context): Intent = Intent(context, ProductCreateActivity::class.java)
    }
}