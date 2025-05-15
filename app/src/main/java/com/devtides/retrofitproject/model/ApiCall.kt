package com.devtides.retrofitproject.model

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query
import retrofit2.http.QueryMap

/**
 * Criado por Gilian Marques
 * Em terça-feira, 22 de abril de 2025 as 19:54.
 */
interface ApiCall {

    @GET("get")
    fun callGet(): Call<ApiCallResponse>

    @POST("post")
    fun callPost(): Call<ApiCallResponse>


    @GET("get?name=jubileu&age=112")
    fun callGetWithStaticParams(): Call<ApiCallResponse>

    @GET("get")
    fun callGetWithDynamicParams(
        @Query("name") name: String,
        @Query("age") age: Int?
    ): Call<ApiCallResponse>

    @GET("get")
    fun callGetWithMapOfParams(@QueryMap params: Map<String, String>): Call<ApiCallResponse>
}