package com.android.example.podomarket.ui.product.create

import android.Manifest
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.android.example.podomarket.AppConstants
import com.android.example.podomarket.AppConstants.Companion.PICK_FROM_CAMERA
import com.android.example.podomarket.R.*
import com.android.example.podomarket.databinding.ActivityProductCreateBinding
import com.gun0912.tedpermission.PermissionListener
import com.gun0912.tedpermission.TedPermission
import org.koin.android.viewmodel.ext.android.viewModel
import java.io.File
import java.io.IOException
import java.text.SimpleDateFormat
import java.util.*

class ProductCreateActivity : AppCompatActivity() {

    private val binding: ActivityProductCreateBinding by lazy {
        DataBindingUtil.setContentView(
            this,
            layout.activity_product_create
        ) as ActivityProductCreateBinding
    }
    private val productCreateViewModel: ProductCreateViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.run {
            toolBar.also { tb ->
                tb.inflateMenu(menu.app_bar_activity_product_create)
                tb.setNavigationIcon(drawable.ic_baseline_arrow_back_24)
                tb.setNavigationOnClickListener { finish() }
                tb.setOnMenuItemClickListener {
                    when(it.itemId) {
                        id.complete_button ->
                            productCreateViewModel
                                .postProduct(
                                    productName.text.toString(),
                                    productPrice.text.toString().toInt()
                                )
                        else -> return@setOnMenuItemClickListener false
                    }
                    return@setOnMenuItemClickListener true
                }
            }
            cameraButton.setOnClickListener {
                tedPermission()
                takePhoto()
            }
            selectCategoryButton.setOnClickListener {
                startActivityForResult(
                    SelectCategoryActivity.intent(this@ProductCreateActivity),
                    AppConstants.SELECT_CATEGORY_ACTIVITY
                )
            }
            priceOfferButton.setOnClickListener {
                productCreateViewModel.toggleAllowSuggest(imgPriceOffer as ImageView)
            }
            selectCityButton.setOnClickListener {
                startActivityForResult(
                    SelectCityActivity.intent(this@ProductCreateActivity),
                    AppConstants.SELECT_CITY_ACTIVITY
                )
            }
        }
    }

    private fun tedPermission() {
        val permissionListener: PermissionListener = object : PermissionListener {
            override fun onPermissionGranted() {
                // 권한 요청 성공
            }

            override fun onPermissionDenied(deniedPermissions: ArrayList<String?>?) {
                // 권한 요청 실패
            }
        }
        TedPermission.with(this)
            .setPermissionListener(permissionListener)
            .setRationaleMessage(resources.getString(string.permission_2))
            .setDeniedMessage(resources.getString(string.permission_1))
            .setPermissions(Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.CAMERA)
            .check()
    }

    private fun takePhoto() {
        val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        var tempFile: File? = null
        try {
            tempFile = createImageFile()
        } catch (e: IOException) {
            Toast.makeText(this, "이미지 처리 오류! 다시 시도해주세요.", Toast.LENGTH_SHORT).show()
            finish()
            e.printStackTrace()
        }
        if (tempFile != null) {
            val photoUri: Uri = Uri.fromFile(tempFile)
            intent.putExtra(MediaStore.EXTRA_OUTPUT, photoUri)
            startActivityForResult(intent, PICK_FROM_CAMERA)
        }
    }

    @Throws(IOException::class)
    private fun createImageFile(): File? {

        // 이미지 파일 이름 ( podomarket_{시간}_ )
        val timeStamp: String = SimpleDateFormat("HHmmss").format(Date())
        val imageFileName = "podomarket_" + timeStamp + "_"

        // 이미지가 저장될 폴더 이름 ( podomarket )
        val storageDir = File(Environment.getExternalStorageDirectory().toString() + "/podomarket/")
        if (!storageDir.exists()) storageDir.mkdirs()

        // 빈 파일 생성
        return File.createTempFile(imageFileName, ".jpg", storageDir)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == PICK_FROM_CAMERA) {

            val photoUri = data?.data
            productCreateViewModel.selectImageFile(photoUri)
        }
    }


    companion object {
        fun intent(context: Context): Intent = Intent(context, ProductCreateActivity::class.java)
    }
}