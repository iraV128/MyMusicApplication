package com.example.myassssmentapplication

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * KoinClient
 *
 * This object provides a singleton Retrofit instance to make API calls to the backend.
 * Although the app uses Koin for dependency injection, this can act as a manual alternative
 * if you are not injecting ApiService through Koin modules.
 */
object KoinClient {

    // 🌐 Base URL for your backend API (update if environment changes)
    private const val BASE_URL = "https://nit3213api.onrender.com/"

    // ✅ Lazily initialized ApiService (created only when first used)
    val instance: ApiService by lazy {
        // 🛠️ Create Retrofit instance with GSON converter
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()) // 🔄 Converts JSON to data classes
            .build()

        // 🔌 Create implementation of your ApiService interface
        retrofit.create(ApiService::class.java)
    }
}
