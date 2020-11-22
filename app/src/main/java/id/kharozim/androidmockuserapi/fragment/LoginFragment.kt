package id.kharozim.androidmockuserapi.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.IdRes
import androidx.navigation.fragment.findNavController
import id.kharozim.androidmockuserapi.R
import id.kharozim.androidmockuserapi.databinding.FragmentLoginBinding
import id.kharozim.androidmockuserapi.helper.Constant
import id.kharozim.androidmockuserapi.helper.PreferencesHelper

class LoginFragment : Fragment() {
    private lateinit var binding: FragmentLoginBinding
    lateinit var sharedPref: PreferencesHelper
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(inflater, container, false).apply {

            sharedPref = PreferencesHelper(requireContext())


            btLogin.setOnClickListener {
                if (tieEmail.text.toString() == sharedPref.getString(Constant.PREF_EMAIL) &&
                    tiePassword.text.toString() == sharedPref.getString(Constant.PREF_PASSWORD)) {
                    sharedPref.put(Constant.PREF_IS_LOGIN, true)
                    moveFragment(R.id.action_loginFragment_to_homeFragment)
                } else{
                    Toast.makeText(
                        requireContext(),
                        "email / password anda salah",
                        Toast.LENGTH_SHORT
                    ).show()
                }

            }

            btRegister.setOnClickListener { findNavController().navigate(R.id.action_loginFragment_to_registerFragment) }

        }
        return binding.root
    }

    private fun moveFragment(@IdRes resId: Int) {
        findNavController().navigate(resId)
    }

    override fun onStart() {
        super.onStart()

//        if (sharedPref.getBoolean(Constant.PREF_IS_LOGIN)) {
//            findNavController().navigate(R.id.action_loginFragment_to_homeFragment)
//            onDestroy()
//        }
    }

}