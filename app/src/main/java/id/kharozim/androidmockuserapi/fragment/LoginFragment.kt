package id.kharozim.androidmockuserapi.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import id.kharozim.androidmockuserapi.R
import id.kharozim.androidmockuserapi.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {
    private lateinit var binding: FragmentLoginBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(inflater, container, false).apply {
            btLogin.setOnClickListener { findNavController().navigate(R.id.action_loginFragment_to_homeFragment) }
            btRegister.setOnClickListener { findNavController().navigate(R.id.action_loginFragment_to_registerFragment) }
        }
        return binding.root
    }


}