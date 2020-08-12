//package com.example.cleanarcdemo.di
//
//import android.content.Context
//import androidx.lifecycle.ViewModelProvider
//import com.example.cleanarcdemo.db.AppDatabase
//import com.example.cleanarcdemo.repository.PlantRepository
//import com.example.cleanarcdemo.repository.PlantRepositoryImpl
//import com.example.cleanarcdemo.service.SunflowerApi
//import com.example.cleanarcdemo.service.SunflowerApiService
//import com.example.cleanarcdemo.viewmodel.PlantViewModelFactory
//
//object Injection {
//    //plant dao singleton
//    private fun plantDao(ctx: Context) = AppDatabase.getInstance(ctx.applicationContext).plantDao()
//
//    private fun providePlantRepository(ctx: Context) : PlantRepository{
//        return PlantRepositoryImpl(provideSunFlowerApiService(), plantDao(ctx))
//    }
//
//    private fun provideSunFlowerApiService() : SunflowerApiService{
//        return SunflowerApiService(SunflowerApi.create())
//    }
//
//    fun providePlantViewModelFactory(ctx : Context) : ViewModelProvider.Factory{
//        return PlantViewModelFactory(providePlantRepository(ctx))
//    }
//}