package com.enigma.rannewsapp

import android.app.ProgressDialog
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.enigma.rannewsapp.databinding.ActivityMainBinding
import com.enigma.rannewsapp.network.ApiService
import com.enigma.rannewsapp.network.NewsInstance
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var apiService : ApiService
    private var progressDialog : ProgressDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        apiService = NewsInstance.apiService

        binding.apply {
            btnGet.setOnClickListener{
                getNews()
            }
        }

    }

    private fun getNews(){
        CoroutineScope(Dispatchers.Main).launch {
            showLoading("Get data, Please wait ...")
            val result = apiService.getNews()
            if(result.isSuccessful){
                Log.e("Successfull, Get Data", "get news successfull ${result.body()?.articles}")
            } else {
                Log.e("Error get data", "getNews failed because ${result.message()}")
            }

            progressDialog?.dismiss()
        }
    }

    private fun showLoading(msg: String)
    {
        progressDialog = ProgressDialog.show(this@MainActivity, null, msg, true)
    }
}