package com.example.myassssmentapplication

/**
 * Data class representing the login request body sent to the API.
 *
 * @param username The user's login name or email.
 * @param password The user's password.
 */
data class LoginRequest(
    val username: String,   // 🧑 The username or email the user enters
    val password: String    // 🔒 The corresponding password for authentication
)
