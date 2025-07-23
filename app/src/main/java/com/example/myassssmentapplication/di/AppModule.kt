package com.example.myassssmentapplication.di

import com.example.myassssmentapplication.ApiService
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Koin module that defines how dependencies are provided throughout the app.
 */
val appModule = module {

    // ✅ Provide a single Retrofit instance
    single {
        Retrofit.Builder()
            .baseUrl("https://nit3213api.onrender.com/") // 🌐 Replace with your actual API base URL
            .addConverterFactory(GsonConverterFactory.create()) // 🔁 Gson converter for JSON serialization
            .build()
    }

    // ✅ Provide a single instance of ApiService using the Retrofit instance
    single<ApiService> {
        // This creates ApiService implementation using Retrofit
        get<Retrofit>().create(ApiService::class.java)
    }
}
