package com.android.example.podomarket.ui.main.product

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android.example.podomarket.data.network.dto.ProductDto
import com.android.example.podomarket.data.repo.ProductRepository
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import timber.log.Timber

class ProductViewModel(private val productRepository: ProductRepository) : ViewModel() {

    val allProduct = MutableLiveData<List<ProductDto>>()

    fun getProductList() {
        productRepository.getProductList()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ response ->
                val paginationResponse = response.body()
                val productList = paginationResponse?.products
                allProduct.postValue(productList)
            }, {
                Timber.e(it)
            })
    }

}