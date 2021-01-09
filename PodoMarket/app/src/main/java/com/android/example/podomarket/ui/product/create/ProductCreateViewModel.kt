package com.android.example.podomarket.ui.product.create

import android.net.Uri
import android.widget.ImageView
import androidx.core.net.toFile
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android.example.podomarket.R
import com.android.example.podomarket.data.repo.ProductRepository
import com.android.example.podomarket.data.repo.UserRepository
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody

class ProductCreateViewModel(private val productRepository: ProductRepository, private val userRepository: UserRepository) : ViewModel() {

    val isAllowSuggest = MutableLiveData<Boolean>(false)
    val selectedImageUri = MutableLiveData<Uri>()
    val selectedImageFile = MutableLiveData<MultipartBody.Part>()
    val currImageNumberStr = MutableLiveData<String>("0/10")
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

    fun selectImageFile(photoUri: Uri?) {
        val file = photoUri?.toFile()
        val fileName = file?.name

        var requestBody : RequestBody = RequestBody.create("image/*".toMediaTypeOrNull(),file!!)
        var body : MultipartBody.Part = MultipartBody.Part.createFormData("uploaded_file",fileName,requestBody)

        selectedImageUri.postValue(photoUri)
        selectedImageFile.postValue(body)
        currImageNumberStr.postValue("1/10")
    }

    fun selectCategory(category: String) {
        selectedCategory.postValue("DIGITAL")
    }

    fun selectCity(cityId: Int) {
        selectedCity.postValue(1)
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
            .observeOn(io.reactivex.rxjava3.android.schedulers.AndroidSchedulers.mainThread())
            .subscribe { response ->

            }
    }

}