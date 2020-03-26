package com.example.cleanarcdemo.data

import androidx.lifecycle.LiveData

data class Result<T>(
    val data : LiveData<T>,
    val networkState: LiveData<NetworkState>
)