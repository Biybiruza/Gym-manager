package com.biybiruza.gemmanagement.ui.home

import android.os.Bundle
import android.se.omapi.Session
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.ActionBarDrawerToggle
import com.biybiruza.gemmanagement.R
import com.biybiruza.gemmanagement.databinding.FragmentHomeBinding
import com.google.android.gms.cast.framework.SessionManager

class HomeFragment : Fragment(R.layout.fragment_home) {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private val TAG = "HomeFragment"
    var session:SessionManager?=null
    var db:DB=null
    private lateinit var toogle: ActionBarDrawerToggle

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentHomeBinding.bind(view)
        db = DB(this)
        session=SessionManager(this)

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding=null
    }
}