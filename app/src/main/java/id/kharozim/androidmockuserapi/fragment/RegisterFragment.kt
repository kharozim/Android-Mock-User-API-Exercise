package id.kharozim.androidmockuserapi.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isInvisible
import androidx.core.view.isVisible
import androidx.navigation.fragment.findNavController
import id.kharozim.androidmockuserapi.R
import id.kharozim.androidmockuserapi.databinding.FragmentRegisterBinding
import id.kharozim.androidmockuserapi.helper.Constant
import id.kharozim.androidmockuserapi.helper.PreferencesHelper


class RegisterFragment : Fragment() {

    private lateinit var binding: FragmentRegisterBinding
    val sharedPref by lazy { PreferencesHelper(requireContext()) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRegisterBinding.inflate(inflater, container, false).apply {

            btRegister.setOnClickListener {
                if (tieName.text.isNullOrEmpty() || tieEmail.text.isNullOrEmpty() || tiePassword.text.isNullOrEmpty()) {
                    Toast.makeText(
                        requireContext(),
                        "form tidak boleh ada yang kosong",
                        Toast.LENGTH_SHORT
                    ).show()
                } else {
                    saveSession(
                        tieName.text.toString(),
                        tieEmail.text.toString(),
                        tiePassword.text.toString()
                    )
                    Toast.makeText(
                        requireContext(),
                        "berhasil menyimpan preferences",
                        Toast.LENGTH_SHORT
                    ).show()
                    findNavController().navigate(R.id.action_registerFragment_to_loginFragment)
                }
            }

        }
        return binding.root
    }

    fun saveSession(name: String, email: String, password: String) {
        sharedPref.put(Constant.PREF_NAME, name)
        sharedPref.put(Constant.PREF_EMAIL, email)
        sharedPref.put(Constant.PREF_PASSWORD, password)
        sharedPref.put(Constant.PREF_IS_REGISTERED, true)
        sharedPref.put(Constant.PREF_IS_LOGIN, false)
    }

}