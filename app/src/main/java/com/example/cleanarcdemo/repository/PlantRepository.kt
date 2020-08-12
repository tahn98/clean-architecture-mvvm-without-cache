package com.example.cleanarcdemo.repository

import androidx.lifecycle.MutableLiveData
import com.example.cleanarcdemo.data.NetworkState
import com.example.cleanarcdemo.data.Plant
import com.example.cleanarcdemo.data.Result
import com.example.cleanarcdemo.db.PlantDao
import com.example.cleanarcdemo.service.SunflowerApiService
import java.util.concurrent.Executors
import javax.inject.Inject

// @Inject lets dagger know how to create instance of PlantRepository object
class PlantRepository @Inject constructor(
    private val apiService: SunflowerApiService,
    private val plantDao: PlantDao
){

    fun getAllPlant(): Result<List<Plant>> {
        val networkState = MutableLiveData<NetworkState>()
        val responsePlant = MutableLiveData<List<Plant>>()
        apiService.getAllPlants(
            onPrepared = {
                networkState.postValue(NetworkState.LOADING)
            },
            onSuccess = { response ->
                Executors.newSingleThreadExecutor().execute { plantDao.insertAll(response ?: listOf()) }
                responsePlant.value = response ?: listOf()
                networkState.postValue(NetworkState.LOADED)
            },
            onError = { errMessage ->
                networkState.postValue(NetworkState.error(errMessage))
            }
        )
        return Result(
            data = responsePlant,
            networkState = networkState
        )
    }

//    companion object {
//        @Volatile
//        private var instance: PlantRepository? = null
//
//        fun getInstance(apiService: SunflowerApiService, plantDao: PlantDao) =
//            instance ?: synchronized(this) {
//                instance ?: PlantRepositoryImpl(apiService, plantDao).also { instance = it }
//            }
//    }
}