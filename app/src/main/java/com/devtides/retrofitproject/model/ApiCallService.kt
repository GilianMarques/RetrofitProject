package com.devtides.retrofitproject.model

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiCallService {

    private val BASE_URL = "https://postman-echo.com/"

    private val api: ApiCall = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(ApiCall::class.java)

    fun call() = api.callGet()

}