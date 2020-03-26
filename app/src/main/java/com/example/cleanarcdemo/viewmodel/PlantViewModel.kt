package com.example.cleanarcdemo.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.cleanarcdemo.data.Plant
import com.example.cleanarcdemo.data.Result
import com.example.cleanarcdemo.repository.PlantRepository

class PlantViewModel (private val repository: PlantRepository) : ViewModel(){

    private val requestAllPlant = MutableLiveData<Result<List<Plant>>>()

    val listPlant = Transformations.switchMap(requestAllPlant){
        it.data
    }

    val networkState = Transformations.switchMap(requestAllPlant){
        it.networkState
    }

    fun getAllPlant(){
        requestAllPlant.value = repository.getAllPlant()
    }
}

class PlantViewModelFactory(
    private val repository: PlantRepository
) : ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>) = PlantViewModel(repository) as T
}