package com.biybiruza.gemmanagement.ui.register

import android.content.Context
import android.content.SharedPreferences
import android.content.SharedPreferences.Editor
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.biybiruza.gemmanagement.R
import com.biybiruza.gemmanagement.appDatabase.AppDatabase
import com.biybiruza.gemmanagement.databinding.FragmentSingUpBinding
import com.biybiruza.gemmanagement.entities.Users

class SingUpFragment : Fragment(R.layout.fragment_sing_up) {

    private lateinit var binding: FragmentSingUpBinding
    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var editor: Editor
    private lateinit var appDatabase: AppDatabase

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSingUpBinding.bind(view)
        appDatabase = AppDatabase.getInstance(requireActivity())
        sharedPreferences = requireActivity().getSharedPreferences("gym",Context.MODE_PRIVATE)
        editor = sharedPreferences.edit()

        binding.apply {
            cvBack.setOnClickListener {
                requireActivity().onBackPressed()
            }

            btnSignUp.setOnClickListener {
                if (etUsername.text.isEmpty()){
                    Toast.makeText(requireActivity(),"Ismingizni kriting!",Toast.LENGTH_LONG).show()
                } else if (etPhone.text.isEmpty()){
                    Toast.makeText(requireActivity(),"Telefon raqamingizni kriting!",Toast.LENGTH_LONG).show()
                } else if (etPassword.text.isEmpty()){
                    Toast.makeText(requireActivity(),"Parol kriting!",Toast.LENGTH_LONG).show()
                } else if (etConfirmPassword.text.isEmpty()){
                    Toast.makeText(requireActivity(),"Parolni qayta kriting!",Toast.LENGTH_LONG).show()
                } else {
                    addUser()
                }
            }
        }
    }

    private fun addUser() {
        binding.apply {
            if (appDatabase.usersDao().checkPhone(etPhone.text.toString())){
                Toast.makeText(requireActivity(),"Bu telefon raqam dizimnan o'tilgan",Toast.LENGTH_LONG).show()
            } else {
                val user = Users(
                    firstName = etUsername.text.toString(),
                    lastName = etLastName.text.toString()?:"",
                    phoneNumber = etPhone.text.toString(),
                    type = "admin",
                    password = etPassword.text.toString()
                )

                Log.d("user", "user: $user")
//                editor.putBoolean("logIn",true)

                appDatabase.usersDao().adduser(user)
                findNavController().navigate(R.id.action_singUpFragment_to_signInFragment)

            }
        }
    }
}