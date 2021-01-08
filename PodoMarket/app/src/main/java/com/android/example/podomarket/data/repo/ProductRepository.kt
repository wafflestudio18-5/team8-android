package com.android.example.podomarket.data.repo

import com.android.example.podomarket.data.network.service.ProductService
import io.reactivex.rxjava3.schedulers.Schedulers

class ProductRepository(private val productService: ProductService) {

    fun getProductList() = productService.getProductList(1, null, null, null, null, null).subscribeOn(Schedulers.io())

    fun getProductById(product_id: Int) = productService.getProductById(product_id)

}