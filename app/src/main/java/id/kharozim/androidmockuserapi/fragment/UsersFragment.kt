package id.kharozim.androidmockuserapi.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import id.kharozim.androidmockuserapi.R
import id.kharozim.androidmockuserapi.UserAdapter
import id.kharozim.androidmockuserapi.UserClient
import id.kharozim.androidmockuserapi.UserResponse
import id.kharozim.androidmockuserapi.databinding.FragmentUsersBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class UsersFragment : Fragment() {

    private lateinit var binding: FragmentUsersBinding
    private val adapter by lazy { UserAdapter(requireContext()) }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentUsersBinding.inflate(inflater, container, false).apply {

            rvUsersFragment.adapter = adapter
            UserClient.userService.getAllUser().enqueue(object : Callback<UserResponse>{
                override fun onResponse(
                    call: Call<UserResponse>,
                    response: Response<UserResponse>
                ) {
                   if (response.isSuccessful && response!= null){
                       response.body()?.let {
                           adapter.setData(it.results)
                       }
                   }
                }

                override fun onFailure(call: Call<UserResponse>, t: Throwable) {
                    TODO("Not yet implemented")
                }

            })


        }
        return binding.root
    }
}