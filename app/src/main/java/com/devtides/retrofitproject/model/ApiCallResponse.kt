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
) {
    fun flatten(): List<Item> {
        val flatpack = arrayListOf<Item>()

        method?.let { flatpack.add(Item("method", method, TYPE_ITEM)) }

        query?.let {
            if (!query.values.isEmpty()) {
                flatpack.add(Item("query", "", TYPE_CATEGORY))
                addMapItems(query, flatpack)
            }
        }

        headerrrs?.let {
            if (!headerrrs.values.isEmpty()) {
                flatpack.add(Item("headers", "", TYPE_CATEGORY))
                addMapItems(headerrrs, flatpack)
            }
        }

        return flatpack
    }

    private fun addMapItems(map: HashMap<String, String>, flatpack: ArrayList<Item>) {

        for (key in map.keys) {
            flatpack.add(Item(key, map[key].toString(), TYPE_ITEM))
        }
    }
}