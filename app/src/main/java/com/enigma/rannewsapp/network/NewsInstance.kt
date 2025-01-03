package com.enigma.rannewsapp.network

import com.enigma.rannewsapp.BuildConfig
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.moshi.MoshiConverterFactory

abstract class NewsInstance {
    companion object{
        fun getDataNews() = Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val apiService : ApiService by lazy {
            com.enigma.rannewsapp.network.NewsInstance.Companion.getDataNews().create(ApiService::class.java)
        }
    }
}