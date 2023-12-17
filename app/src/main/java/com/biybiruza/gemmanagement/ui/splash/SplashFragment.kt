package com.biybiruza.gemmanagement.ui.splash

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.fragment.findNavController
import com.biybiruza.gemmanagement.R
import com.biybiruza.gemmanagement.appDatabase.AppDatabase
import com.biybiruza.gemmanagement.databinding.FragmentSplashBinding
import com.biybiruza.gemmanagement.entities.Users

class SplashFragment : Fragment(R.layout.fragment_splash) {

    private lateinit var binding: FragmentSplashBinding
    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var database: AppDatabase

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        database = AppDatabase.getInstance(requireActivity())
        binding = FragmentSplashBinding.bind(view)

        Handler().postDelayed({
            if (isLogIn()){
                binding.progress.visibility = View.GONE
                findNavController().navigate(R.id.action_splashFragment_to_homeFragment)
            } else {
                findNavController().navigate(R.id.action_splashFragment_to_signInFragment)
            }

        },4000)
    }

    private fun isLogIn(): Boolean {
        sharedPreferences = requireActivity().getSharedPreferences("gym", Context.MODE_PRIVATE)
        return sharedPreferences.getBoolean("logIn",false)
    }
}