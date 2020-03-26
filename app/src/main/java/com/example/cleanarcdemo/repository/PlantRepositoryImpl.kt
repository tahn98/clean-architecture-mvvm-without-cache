package com.example.cleanarcdemo.repository

import androidx.lifecycle.MutableLiveData
import com.example.cleanarcdemo.data.NetworkState
import com.example.cleanarcdemo.data.Plant
import com.example.cleanarcdemo.data.Result
import com.example.cleanarcdemo.service.SunflowerApiService

class PlantRepositoryImpl(private val apiService: SunflowerApiService) : PlantRepository {

    override fun getAllPlant(): Result<List<Plant>>{
        val networkState = MutableLiveData<NetworkState>()
        val responsePlant = MutableLiveData<List<Plant>>()
        apiService.getAllPlants(
            onPrepared = {
                networkState.postValue(NetworkState.LOADING)
            },
            onSuccess = {response ->
                responsePlant.value = response ?: listOf()
                networkState.postValue(NetworkState.LOADED)
            },
            onError = {errMessage ->
                networkState.postValue(NetworkState.error(errMessage))
            }
        )
        return Result(
            data = responsePlant,
            networkState = networkState
        )
    }
}