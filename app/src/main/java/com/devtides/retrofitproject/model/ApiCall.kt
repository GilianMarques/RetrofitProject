package com.devtides.retrofitproject.model

import retrofit2.Call
import retrofit2.http.GET

/**
 * Criado por Gilian Marques
 * Em terça-feira, 22 de abril de 2025 as 19:54.
 */
interface ApiCall {

    @GET("apiCall")
    fun callGet(): Call<ApiCallResponse>
}