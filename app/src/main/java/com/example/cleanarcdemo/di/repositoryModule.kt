package com.example.cleanarcdemo.di

import com.example.cleanarcdemo.repository.PlantRepository
import com.example.cleanarcdemo.repository.PlantRepositoryImpl
import org.koin.dsl.module

val repositoryModule = module {
    single<PlantRepository> { PlantRepositoryImpl(get()) }
}