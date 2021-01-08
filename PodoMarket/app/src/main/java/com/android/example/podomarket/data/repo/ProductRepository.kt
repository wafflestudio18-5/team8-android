package com.android.example.podomarket.data.repo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.android.example.podomarket.data.network.dto.ProductDto
import com.android.example.podomarket.data.network.service.ProductService
import io.reactivex.rxjava3.schedulers.Schedulers

class ProductRepository(private val service: ProductService) {

    fun getProductList(): LiveData<List<ProductDto>> {
        val result: MutableLiveData<List<ProductDto>> = MutableLiveData()
        val singleResponse = service.getProductList(1, null, null, null, null, null)

        singleResponse
            .subscribeOn(Schedulers.io())
            .subscribe { response ->
                val paginationResponse = response.body()
                val productList = paginationResponse?.products
                result.postValue(productList)
            }

        return result
    }

}