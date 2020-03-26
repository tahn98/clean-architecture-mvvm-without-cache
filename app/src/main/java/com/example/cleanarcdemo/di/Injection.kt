package com.example.cleanarcdemo.di

import androidx.lifecycle.ViewModelProvider
import com.example.cleanarcdemo.repository.PlantRepository
import com.example.cleanarcdemo.repository.PlantRepositoryImpl
import com.example.cleanarcdemo.service.SunflowerApi
import com.example.cleanarcdemo.service.SunflowerApiService
import com.example.cleanarcdemo.viewmodel.PlantViewModelFactory

object Injection {
    private fun providePlantRepository() : PlantRepository{
        return PlantRepositoryImpl(provideSunFlowerApiService())
    }

    private fun provideSunFlowerApiService() : SunflowerApiService{
        return SunflowerApiService(SunflowerApi.create())
    }

    fun providePlantViewModelFactory() : ViewModelProvider.Factory{
        return PlantViewModelFactory(providePlantRepository())
    }
}