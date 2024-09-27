package com.example.myapplication.repository

import com.example.myapplication.network.AgifyAPIService
import com.example.myapplication.network.data.AgifyResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class AgifyRepository @Inject constructor(
    private val agifyAPIService: AgifyAPIService
)  {
    suspend fun getAgeOfNameFromNetwork(name: String): AgifyResponse {
        return withContext(Dispatchers.IO) {
            agifyAPIService.getAge(name)
        }
    }
}