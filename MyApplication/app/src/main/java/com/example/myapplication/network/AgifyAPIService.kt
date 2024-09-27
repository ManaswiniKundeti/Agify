package com.example.myapplication.network

import com.example.myapplication.network.data.AgifyResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface AgifyAPIService {

    @GET(".")
    suspend fun getAge(@Query("name") name: String) : AgifyResponse
}