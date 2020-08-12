package com.example.cleanarcdemo.di

import com.example.cleanarcdemo.service.SunflowerApi
import com.example.cleanarcdemo.service.SunflowerApiService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val networkModule = module {
    single {
        createService<SunflowerApi>(get())
    }

    single {
        createOkHttpClient()
    }

    single {
        SunflowerApiService(get())
    }
}

fun createOkHttpClient(): OkHttpClient {
    val httpLoggingInterceptor = HttpLoggingInterceptor()
    httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
    return OkHttpClient.Builder()
        .addInterceptor(httpLoggingInterceptor)
        .build()
}

inline fun <reified T> createService(okHttpClient: OkHttpClient): T {
    val retrofit = Retrofit.Builder()
        .baseUrl("https://raw.githubusercontent.com/")
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    return retrofit.create(T::class.java)
}
