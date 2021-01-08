package com.android.example.podomarket.ui.main.product

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.android.example.podomarket.data.network.dto.ProductDto
import com.android.example.podomarket.data.repo.ProductRepository

class ProductViewModel(private val repo: ProductRepository) : ViewModel() {
    val allProduct: LiveData<List<ProductDto>> = repo.getProductList()
}