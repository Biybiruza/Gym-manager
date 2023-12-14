package com.biybiruza.gemmanagement.ui.splash

import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.fragment.findNavController
import com.biybiruza.gemmanagement.R
import com.biybiruza.gemmanagement.databinding.FragmentHomeBinding
import com.biybiruza.gemmanagement.databinding.FragmentSplashBinding

class SplashFragment : Fragment(R.layout.fragment_splash) {
    private var _binding: FragmentSplashBinding? = null
    private val binding get() = _binding!!
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentSplashBinding.bind(view)

        Handler().postDelayed({
            binding.progress.visibility = View.GONE
            findNavController().navigate(R.id.action_splashFragment_to_signInFragment)
        },3000)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding=null
    }
}