package id.kharozim.androidmockuserapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import id.kharozim.androidmockuserapi.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


    }
}