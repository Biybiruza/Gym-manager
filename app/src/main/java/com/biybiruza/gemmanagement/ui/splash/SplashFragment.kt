package com.biybiruza.gemmanagement.ui.splash

import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.View
import com.biybiruza.gemmanagement.R
import com.biybiruza.gemmanagement.databinding.FragmentSplashBinding

class SplashFragment : Fragment(R.layout.fragment_splash) {

    private lateinit var binding: FragmentSplashBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSplashBinding.bind(view)

        Handler().postDelayed({
            binding.progress.visibility = View.GONE
        },3000)
    }
}