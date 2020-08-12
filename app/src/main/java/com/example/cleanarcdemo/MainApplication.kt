package com.example.cleanarcdemo

import android.app.Application
import com.example.cleanarcdemo.di.appModule
import com.example.cleanarcdemo.di.networkModule
import com.example.cleanarcdemo.di.repositoryModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.module.Module

class MainApplication: Application(){
    companion object{
        lateinit var instance : MainApplication
            private set
    }

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@MainApplication)
            modules(getModules())
        }

        instance = this
    }

    private fun getModules(): List<Module> {
        val moduleList = arrayListOf<Module>()
        moduleList.addAll(listOf(networkModule, repositoryModule, appModule))
        return moduleList
    }
}