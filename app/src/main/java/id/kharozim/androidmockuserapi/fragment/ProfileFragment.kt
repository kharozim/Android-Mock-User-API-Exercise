package id.kharozim.androidmockuserapi.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import id.kharozim.androidmockuserapi.R
import id.kharozim.androidmockuserapi.databinding.FragmentProfileBinding
import id.kharozim.androidmockuserapi.helper.Constant
import id.kharozim.androidmockuserapi.helper.PreferencesHelper

class ProfileFragment : Fragment() {

private lateinit var binding : FragmentProfileBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       binding = FragmentProfileBinding.inflate(inflater, container, false).apply {
           val sharepref = PreferencesHelper(requireContext())

           tvName.text = sharepref.getString(Constant.PREF_NAME)
           tvEmail.text = sharepref.getString(Constant.PREF_EMAIL)
           tvPassword.text = sharepref.getString(Constant.PREF_PASSWORD)

       }















        return binding.root
    }

}