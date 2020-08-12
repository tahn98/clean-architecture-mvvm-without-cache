package com.example.cleanarcdemo.di

import com.example.cleanarcdemo.service.SunflowerApi
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class NetworkModule {
    @Provides
    fun providesSunflowerApi() : SunflowerApi {
        return SunflowerApi.create()
    }
}