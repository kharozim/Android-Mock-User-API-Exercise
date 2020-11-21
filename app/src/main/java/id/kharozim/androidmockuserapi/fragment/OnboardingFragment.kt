package id.kharozim.androidmockuserapi.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import id.kharozim.androidmockuserapi.MainActivity
import id.kharozim.androidmockuserapi.R
import id.kharozim.androidmockuserapi.databinding.FragmentOnboardingBinding


class OnboardingFragment : Fragment() {

    private lateinit var binding: FragmentOnboardingBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOnboardingBinding.inflate(inflater, container, false).apply {

            btLogin.setOnClickListener { findNavController().navigate(R.id.action_onboardingFragment2_to_loginFragment) }
            btRegister.setOnClickListener { findNavController().navigate(R.id.action_onboardingFragment2_to_registerFragment) }
        }
        return binding.root
    }
}