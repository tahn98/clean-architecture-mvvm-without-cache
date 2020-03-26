package com.example.cleanarcdemo.service

import com.example.cleanarcdemo.data.Plant

class SunflowerApiService(private val apiApi: SunflowerApi) {

    fun getAllPlants(
        onPrepared : () -> Unit,
        onSuccess : (List<Plant>?) -> Unit,
        onError : (String) -> Unit
    ){
        val request = apiApi.getAllPlants()
        onPrepared()
        ApiRequestHelper.asyncRequest(request, onSuccess, onError)
    }
}