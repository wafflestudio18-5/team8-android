package com.android.example.podomarket.ui.user

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.android.example.podomarket.R
import com.android.example.podomarket.databinding.ActivityLoginBinding
import com.android.example.podomarket.ui.main.MainActivity
import com.kakao.sdk.auth.LoginClient
import com.kakao.sdk.auth.rx
import io.reactivex.android.schedulers.AndroidSchedulers

class LoginActivity : AppCompatActivity() {

    val binding: ActivityLoginBinding by lazy {
        DataBindingUtil.setContentView(this, R.layout.activity_login)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.run {
            testButton.setOnClickListener {
                LoginClient.rx.loginWithKakaoAccount(this@LoginActivity)
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe({ token ->
                        startActivity(Intent(this@LoginActivity, MainActivity::class.java))
                    }, { error ->
                        Toast.makeText(this@LoginActivity, error.toString(), Toast.LENGTH_LONG)
                            .show()
                    })
            }
        }
    }
}