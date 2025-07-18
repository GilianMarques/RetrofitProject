package com.devtides.retrofitproject.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.devtides.retrofitproject.model.ApiCallResponse
import com.devtides.retrofitproject.model.ApiCallService
import com.devtides.retrofitproject.model.Item
import com.devtides.retrofitproject.model.TYPE_CATEGORY
import com.devtides.retrofitproject.model.TYPE_ITEM
import kotlinx.coroutines.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel : ViewModel() {

    var job: Job? = null
    val exceptionHandler = CoroutineExceptionHandler { coroutineContext, throwable ->
        GlobalScope.launch(Dispatchers.Main) {
            onError("Exception: ${throwable.localizedMessage}")
        }
    }

    val apiResponse = MutableLiveData<List<Item>>()
    val loading = MutableLiveData<Boolean>()
    val error = MutableLiveData<String>()

    fun fetchData() {
        loading.value = true

        val callback = object : Callback<ApiCallResponse> {
            override fun onResponse(
                call: Call<ApiCallResponse?>,
                response: Response<ApiCallResponse?>
            ) {
                val body = response.body() // this should contain all response data
                apiResponse.value = body?.flatten()
                error.value = null
                loading.value = false
            }

            override fun onFailure(call: Call<ApiCallResponse?>, t: Throwable) {
                onError(t.localizedMessage)
            }

        }

        ApiCallService.call()
            /*enqueue roda de forma assincrona*/
            .enqueue(callback)

    }

    private fun onError(message: String) {
        error.value = message
        loading.value = false
    }

    override fun onCleared() {
        super.onCleared()
        job?.cancel()
    }
}