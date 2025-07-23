package com.example.myassssmentapplication

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

/**
 * Retrofit service interface for defining API endpoints.
 * Each function corresponds to a network request.
 */
interface ApiService {

    /**
     * Sends a POST request to the login/authentication endpoint.
     *
     * @param request The login credentials wrapped in a LoginRequest object.
     * @return A Call object that will return a LoginResponse from the server.
     */
    @POST("sydney/auth") // 🔁 Endpoint to authenticate the user (adjust if needed)
    fun login(@Body request: LoginRequest): Call<LoginResponse>

    /**
     * Sends a GET request to fetch dashboard data with the given keypass.
     *
     * @param keypass A dynamic path parameter used to authorize the request.
     * @return A Call object that will return DashboardResponse containing album data.
     */
    @GET("dashboard/{keypass}")
    fun getDashboardData(@Path("keypass") keypass: String): Call<DashboardResponse>
}
