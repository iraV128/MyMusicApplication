package com.example.myassssmentapplication

/**
 * Data class representing the response returned from the login API.
 *
 * @param keypass A unique token or key used to authenticate future requests (e.g., to fetch dashboard data).
 */
data class LoginResponse(
    val keypass: String // 🔑 Key or access token returned after successful login
)
