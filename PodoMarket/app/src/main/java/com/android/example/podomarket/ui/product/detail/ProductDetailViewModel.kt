package com.android.example.podomarket.ui.product.detail

import android.widget.ImageView
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android.example.podomarket.R
import com.android.example.podomarket.data.network.dto.ProductDto
import com.android.example.podomarket.data.network.dto.UserDto
import com.android.example.podomarket.data.repo.ProductRepository
import com.android.example.podomarket.data.repo.UserRepository
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import timber.log.Timber

class ProductDetailViewModel(private val productRepository: ProductRepository,
                                private val userRepository: UserRepository) : ViewModel() {

    val theProduct = MutableLiveData<ProductDto>()
    val existLike = MutableLiveData<Boolean>()
    val theSeller = MutableLiveData<UserDto>()

    fun getProductById(productId: Int) {
        productRepository.getProductById(productId)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ response ->
                theProduct.postValue(response.body())
            }, {
                Timber.e(it)
            })
        theProduct.value?.seller?.let {
            userRepository.getUserInfo(it)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ response ->
                    theSeller.postValue(response.body())
                }, {
                    Timber.e(it)
                })
        }
    }

    fun putLikeProduct(productId: Int, imageView: ImageView) {
        productRepository.putLikeProduct(productId)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ response ->
                val likeProductDto = response.body()
                existLike.postValue(likeProductDto?.active)
                if (likeProductDto?.active == true) {
                    imageView.setColorFilter(R.color.purple_500)
                } else {
                    imageView.setColorFilter(R.color.dark_gray)
                }
            }, {
                Timber.e(it)
            })
    }
}