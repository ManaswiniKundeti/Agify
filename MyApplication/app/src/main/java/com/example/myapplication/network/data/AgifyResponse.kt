package com.example.myapplication.network.data

import com.google.gson.annotations.SerializedName

data class AgifyResponse(
    val count: Int?,
    val name: String?,
    val age: Int?,
    @SerializedName("country_id") val countryId: String?
)
