package com.biybiruza.gemmanagement.ui.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.biybiruza.gemmanagement.R
import com.biybiruza.gemmanagement.appDatabase.AppDatabase
import com.biybiruza.gemmanagement.databinding.FragmentSignInBinding
import java.lang.Appendable

class SignInFragment : Fragment(R.layout.fragment_sign_in) {

    private lateinit var binding: FragmentSignInBinding
    private lateinit var appDatabase: AppDatabase

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        appDatabase = AppDatabase.getInstance(requireActivity())
        binding = FragmentSignInBinding.bind(view)

        binding.apply {

            tvSignUp.setOnClickListener {
                findNavController().navigate(R.id.action_signInFragment_to_singUpFragment)
            }

            btnSignIn.setOnClickListener {
                if (etUsername.text.equals("")) {
                    Toast.makeText(requireActivity(), "Username kiriting", Toast.LENGTH_LONG).show()
                } else if (etPhone.text.equals("")) {
                    Toast.makeText(requireActivity(), "Telefon raqam kiriting", Toast.LENGTH_LONG)
                        .show()
                } else {
                    if (appDatabase.usersDao().checkPhoneAndPassword(
                            etPhone.text.toString(),
                            etPassword.text.toString()
                        )
                    ) {
                        findNavController().navigate(R.id.action_signInFragment_to_homeFragment)
                    } else {
                        Toast.makeText(
                            requireActivity(),
                            "Bu raqam ro'yxatdan o'tilmagan",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                }
            }
        }
    }

}