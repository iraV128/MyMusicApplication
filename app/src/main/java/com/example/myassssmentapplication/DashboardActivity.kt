package com.example.myassssmentapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import org.koin.android.ext.android.inject

/**
 * Activity that displays a list of albums fetched from the dashboard API.
 */
class DashboardActivity : AppCompatActivity() {

    // ✅ Inject ApiService using Koin DI
    private val apiService: ApiService by inject()

    private lateinit var recyclerView: RecyclerView
    private lateinit var albumAdapter: AlbumAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        // 🔐 Extract the 'keypass' passed from the login screen
        val keypass = intent.getStringExtra("keypass") ?: return

        // 📦 Set up RecyclerView and adapter
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // 🎯 Set up adapter with click listener to navigate to DetailsActivity
        albumAdapter = AlbumAdapter { album ->
            val intent = Intent(this, DetailsActivity::class.java)
            intent.putExtra("album", album) // Album is Serializable
            startActivity(intent)
        }

        recyclerView.adapter = albumAdapter

        // 🚀 Fetch dashboard (album) data from API
        apiService.getDashboardData(keypass)
            .enqueue(object : Callback<DashboardResponse> {

                // ✅ API call successful
                override fun onResponse(call: Call<DashboardResponse>, response: Response<DashboardResponse>) {
                    if (response.isSuccessful) {
                        // 🎉 Update adapter data with list of albums
                        val albums = response.body()?.entities ?: emptyList()
                        albumAdapter.setAlbums(albums)
                    } else {
                        // ❌ API responded but with failure (e.g. 400/500)
                        Toast.makeText(this@DashboardActivity, "Failed to load data", Toast.LENGTH_SHORT).show()
                    }
                }

                // ❌ Network error, timeout, etc.
                override fun onFailure(call: Call<DashboardResponse>, t: Throwable) {
                    Toast.makeText(this@DashboardActivity, "Error: ${t.message}", Toast.LENGTH_SHORT).show()
                }
            })
    }
}
