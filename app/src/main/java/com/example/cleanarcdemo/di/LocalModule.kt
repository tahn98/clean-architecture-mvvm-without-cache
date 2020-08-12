package com.example.cleanarcdemo.di

import android.app.Application
import androidx.room.Room
import com.example.cleanarcdemo.db.AppDatabase
import com.example.cleanarcdemo.db.PlantDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

private const val DATABASE_NAME = "sunflower-db"

@Module
class LocalModule {
    @Provides
    fun providesPlantDao(application: Application) : PlantDao{
        return Room.databaseBuilder(application, AppDatabase::class.java, DATABASE_NAME).build().plantDao()
    }
}