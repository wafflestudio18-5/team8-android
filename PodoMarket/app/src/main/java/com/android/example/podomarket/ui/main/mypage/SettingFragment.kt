package com.android.example.podomarket.ui.main.mypage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.android.example.podomarket.R
import com.android.example.podomarket.databinding.FragmentSettingBinding
import com.android.example.podomarket.ui.user.login.LoginActivity
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.kakao.sdk.user.UserApiClient
import timber.log.Timber


class SettingFragment : Fragment() {


    lateinit var binding: FragmentSettingBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_setting, container, false)
        // Configure sign-in to request the user's ID, email address, and basic
        // profile. ID and basic profile are included in DEFAULT_SIGN_IN.
        val gso: GoogleSignInOptions =
            GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .build()
        val mGoogleSignInClient = activity?.let { GoogleSignIn.getClient(it, gso) }
        binding.run {
            toolBar.also { tb ->
                tb.setNavigationIcon(R.drawable.ic_baseline_arrow_back_24)
                tb.setNavigationOnClickListener {
                    findNavController().navigateUp()
                }
            }
            signOutButton.setOnClickListener {
                //Google Logout
                GoogleSignIn.getLastSignedInAccount(activity)?.run {
                    mGoogleSignInClient?.signOut()
                        ?.addOnCompleteListener {
                            activity?.startActivity(LoginActivity.intent(requireActivity()))
                            activity?.finish()
                        }
                }
                //Kakao Logout
                UserApiClient.instance.logout { error ->
                    error?.also {
                        Timber.e(error)
                    } ?: run {
                        activity?.startActivity(LoginActivity.intent(requireActivity()))
                        activity?.finish()
                    }
                }
                //TODO : REMOVE DRF Token
            }
        }
        return binding.root
    }

}