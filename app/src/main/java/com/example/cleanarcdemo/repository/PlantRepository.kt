package com.example.cleanarcdemo.repository

import com.example.cleanarcdemo.data.Plant
import com.example.cleanarcdemo.data.Result

interface PlantRepository{
    fun getAllPlant() : Result<List<Plant>>
}