package com.android.example.podomarket.ui.product.create

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.android.example.podomarket.R
import com.android.example.podomarket.databinding.ActivitySelectCityBinding
import org.koin.android.viewmodel.ext.android.viewModel

class SelectCityActivity : AppCompatActivity() {
    private val selectCityViewModel: SelectCityViewModel by viewModel()
    private val binding: ActivitySelectCityBinding by lazy {
        DataBindingUtil.setContentView(
            this,
            R.layout.activity_select_city
        ) as ActivitySelectCityBinding
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.run {
            toolBar.also { tb ->
                tb.setNavigationIcon(R.drawable.ic_baseline_arrow_back_24)
                tb.setNavigationOnClickListener { finish() }
            }
            lifecycleOwner = this@SelectCityActivity
            viewModel = selectCityViewModel
            adapter = SelectCityAdapter {
                val intent = Intent().apply {
                    putExtra("city_id", it.city_id)
                }
                setResult(RESULT_OK, intent)
                finish()
            }
        }
    }

    companion object {
        fun intent(context: Context): Intent = Intent(context, SelectCityActivity::class.java)
    }
}