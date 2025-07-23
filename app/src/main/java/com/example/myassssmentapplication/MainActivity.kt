package com.example.myassssmentapplication

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * MainActivity
 *
 * This activity allows the user to log in by entering a username and password.
 * On successful login, the app fetches the keypass and navigates to DashboardActivity.
 */
class MainActivity : AppCompatActivity() {

    // ✅ UI components
    lateinit var etUsername: EditText  // 🧑 Input field for username
    lateinit var etPassword: EditText  // 🔒 Input field for password
    lateinit var btnLogin: Button      // 🔓 Button to trigger login action
    lateinit var tvResult: TextView    // 🪧 TextView to display messages (e.g. success, errors)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 🔗 Link UI elements to their XML counterparts
        etUsername = findViewById(R.id.etUsername)
        etPassword = findViewById(R.id.etPassword)
        btnLogin = findViewById(R.id.btnLogin)
        tvResult = findViewById(R.id.tvResult)

        // 🔘 Set click listener for Login button
        btnLogin.setOnClickListener {
            val username = etUsername.text.toString().trim()
            val password = etPassword.text.toString().trim()

            // ⚠️ Input validation: check for empty fields
            if (username.isEmpty() || password.isEmpty()) {
                tvResult.text = "Please fill all fields"
                return@setOnClickListener
            }

            // 📦 Create login request object to be sent to the API
            val request = LoginRequest(username, password)

            // 🌐 Send login request using Retrofit
            KoinClient.instance.login(request).enqueue(object : Callback<LoginResponse> {

                /**
                 * ✅ Called when server responds
                 */
                override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                    if (response.isSuccessful) {
                        // 🎉 Login successful, extract keypass
                        val keypass = response.body()?.keypass
                        tvResult.text = "Login success! keypass: $keypass"

                        // 🚀 Navigate to DashboardActivity and pass keypass via intent
                        val intent = Intent(this@MainActivity, DashboardActivity::class.java)
                        intent.putExtra("keypass", keypass)
                        startActivity(intent)
                    } else {
                        // ❌ Server responded with error status
                        tvResult.text = "Login failed: ${response.code()}"
                    }
                }

                /**
                 * ❌ Called when the request itself fails (e.g. no network)
                 */
                override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                    tvResult.text = "Network error: ${t.message}"
                }
            })
        }
    }
}
