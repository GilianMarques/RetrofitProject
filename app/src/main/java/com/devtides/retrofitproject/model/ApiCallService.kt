package com.devtides.retrofitproject.model

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiCallService {

    private const val BASE_URL = "https://postman-echo.com/"

    private val okHttpClient = OkHttpClient.Builder()

    private val api: ApiCall by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient.build())
            .build()
            .create(ApiCall::class.java)
    }

    init {
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.HEADERS
        okHttpClient.addInterceptor(logging)
    }

    fun call() = api.callGetWithMapOfParams(hashMapOf("name" to "jubileu", "age" to "112"))

}