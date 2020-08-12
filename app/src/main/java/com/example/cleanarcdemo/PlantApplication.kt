package com.example.cleanarcdemo

import android.app.Application
import com.example.cleanarcdemo.db.PlantDao
import com.example.cleanarcdemo.di.ApplicationModule
import com.example.cleanarcdemo.di.LocalModule
import com.example.cleanarcdemo.di.NetworkModule
import com.example.cleanarcdemo.repository.PlantRepository
import com.example.cleanarcdemo.ui.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [LocalModule::class, NetworkModule::class, ApplicationModule::class])
interface ApplicationComponent{
    fun inject(activity: MainActivity)
}

class PlantApplication : Application() {
    val applicationComponent: ApplicationComponent =
        DaggerApplicationComponent.builder()
            .applicationModule(ApplicationModule(this))
            .localModule(LocalModule())
            .networkModule(NetworkModule())
            .build()
}