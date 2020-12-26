package com.android.example.podomarket.ui.user

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.android.example.podomarket.R
import com.android.example.podomarket.databinding.ActivityLoginBinding
import com.android.example.podomarket.ui.main.MainActivity
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.SignInButton
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.tasks.Task
import com.kakao.sdk.auth.LoginClient
import com.kakao.sdk.auth.rx
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers


class LoginActivity : AppCompatActivity() {

    val binding: ActivityLoginBinding by lazy {
        DataBindingUtil.setContentView(this, R.layout.activity_login)
    }

    companion object {
        const val RC_SIGN_IN = 100
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Configure sign-in to request the user's ID, email address, and basic
        // profile. ID and basic profile are included in DEFAULT_SIGN_IN.
        val gso: GoogleSignInOptions =
            GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.server_client_id))
                .build()
        val mGoogleSignInClient = GoogleSignIn.getClient(this, gso)

        binding.run {
            googleSignInButton.setSize(SignInButton.SIZE_WIDE)
            googleSignInButton.setOnClickListener {
                startActivityForResult(mGoogleSignInClient.signInIntent, RC_SIGN_IN)
            }
            kakaoSignInButton.setOnClickListener {
                // 카카오톡이 설치되어 있으면 카카오톡으로 로그인, 아니면 카카오계정으로 로그인
                Single.just(LoginClient.instance.isKakaoTalkLoginAvailable(this@LoginActivity))
                    .flatMap { available ->
                        if (available)
                            LoginClient.rx.loginWithKakaoTalk(this@LoginActivity)
                        else
                            LoginClient.rx.loginWithKakaoAccount(this@LoginActivity)
                    }
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe({ token ->
                        Toast.makeText(
                            this@LoginActivity,
                            "Access Token : ${token.accessToken}",
                            Toast.LENGTH_LONG
                        ).show()
                        startActivity(Intent(this@LoginActivity, MainActivity::class.java))
                        finish()
                    }, { error ->
                        Toast.makeText(this@LoginActivity, error.toString(), Toast.LENGTH_LONG)
                            .show()
                    })
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        // Result returned from launching the Intent from GoogleSignInClient.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            // The Task returned from this call is always completed, no need to attach
            // a listener.
            val task: Task<GoogleSignInAccount> =
                GoogleSignIn.getSignedInAccountFromIntent(data)
            handleSignInResult(task)
        }
    }

    private fun handleSignInResult(completedTask: Task<GoogleSignInAccount>) {
        try {
            val account: GoogleSignInAccount? = completedTask.getResult(ApiException::class.java)
            Toast.makeText(this, "ID Token : " + account?.idToken, Toast.LENGTH_LONG).show()
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        } catch (e: ApiException) {
            Log.i("LoginActivity", e.toString())
        }
    }
}