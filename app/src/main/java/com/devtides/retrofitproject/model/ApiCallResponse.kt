package com.devtides.retrofitproject.model

import com.google.gson.annotations.SerializedName

/**
 * Criado por Gilian Marques
 * Em terça-feira, 22 de abril de 2025 as 19:46.
 */
data class ApiCallResponse(
    val method: String?,
    val query: HashMap<String, String>?,
    @SerializedName("headers")
    val headerrrs: HashMap<String, String>?
)