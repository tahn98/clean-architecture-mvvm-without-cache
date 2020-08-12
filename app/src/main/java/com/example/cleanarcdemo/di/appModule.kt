package com.example.cleanarcdemo.di


import com.example.cleanarcdemo.viewmodel.PlantViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel { PlantViewModel(get()) }
}