package com.android.example.podomarket.ui.product.create

import android.widget.ImageView
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android.example.podomarket.R
import com.android.example.podomarket.data.repo.ProductRepository
import com.android.example.podomarket.data.repo.UserRepository
import okhttp3.MultipartBody

class ProductCreateViewModel(private val productRepository: ProductRepository, private val userRepository: UserRepository) : ViewModel() {

    val isAllowSuggest = MutableLiveData<Boolean>(false)
    val selectedImageFile = MutableLiveData<MultipartBody.Part>()
    val currentImageNumber = MutableLiveData<Int>(0)
    val selectedCategory = MutableLiveData<String>("DIGITAL")
    val selectedCity = MutableLiveData<Int>(1)

    fun toggleAllowSuggest(imageView: ImageView) {
        isAllowSuggest.postValue(!isAllowSuggest.value!!)
        if (isAllowSuggest.value == true) {
            imageView.setImageResource(R.drawable.ic_baseline_check_circle_24)
        } else {
            imageView.setImageResource(R.drawable.ic_baseline_check_circle_outline_24)
        }
    }

    fun selectImageFile(fileName: String) {
    }

    fun selectCategory(category: String) {
    }

    fun selectCity(cityId: Int) {
    }

    fun postProduct(name: String,
                    price: Int) {
        val userId = userRepository.getMyInfo()?.id
        productRepository
            .postProduct(name,
                        selectedCategory.value!!,
                        price,
                        isAllowSuggest.value!!,
                        selectedCity.value!!,
                        userId!!,
                        selectedImageFile.value!!)
    }

}