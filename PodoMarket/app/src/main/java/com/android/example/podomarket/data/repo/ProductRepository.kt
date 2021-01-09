package com.android.example.podomarket.data.repo

import com.android.example.podomarket.data.network.service.ProductService
import io.reactivex.rxjava3.schedulers.Schedulers
import okhttp3.MultipartBody

class ProductRepository(private val productService: ProductService) {

    fun getProductList() = productService.getProductList(1, null, null, null, null, null).subscribeOn(Schedulers.io())

    fun getProductById(product_id: Int) = productService.getProductById(product_id).subscribeOn(Schedulers.io())

    fun postProduct(name: String,
                    category: String,
                    price: Int,
                    allow_suggest: Boolean,
                    city: Int,
                    seller: Int,
                    imgFile:MultipartBody.Part)
        = productService.postProduct(name, category, price, allow_suggest, city, seller, imgFile).subscribeOn(Schedulers.io())

    fun putLikeProduct(product_id: Int) = productService.putLikeProduct(product_id).subscribeOn(Schedulers.io())

}