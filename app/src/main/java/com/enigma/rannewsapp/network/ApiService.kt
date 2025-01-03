package com.enigma.rannewsapp.network

import com.enigma.rannewsapp.network.response.BasicResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("/v2/everything?q=apple&from=2025-01-02&to=2025-01-02&sortBy=popularity&apiKey=4d939f8616b44241b13dfd4e5f4c41a0")
    suspend fun getNews() : Response<BasicResponse>
}