package com.example.myassssmentapplication

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

/**
 * DetailsActivity
 *
 * This activity shows detailed information about a single Album selected from the dashboard.
 * It receives the Album data via intent and displays it in a TextView.
 */
class DetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        // 🎁 Receive the Album object passed from DashboardActivity via Intent
        val album = intent.getSerializableExtra("album") as? Album

        // 🖋️ Reference to the TextView to display album details
        val tvDetails = findViewById<TextView>(R.id.tvDetails)

        // ✅ Populate the TextView only if album data was successfully received
        album?.let {
            // 📋 Build a formatted string from the Album fields
            val details = """
                Artist: ${it.artistName}
                Album: ${it.albumTitle}
                Year: ${it.releaseYear}
                Genre: ${it.genre}
                Tracks: ${it.trackCount}
                
                Description:
                ${it.description}
                
                Popular Track: ${it.popularTrack}
            """.trimIndent()

            // 🖨️ Display the album details
            tvDetails.text = details
        }

        // 🔙 Setup the back button to finish the activity
        val btnBack = findViewById<Button>(R.id.btnBack)

        btnBack.setOnClickListener {
            // 🔚 Close this activity and return to the previous one (DashboardActivity)
            finish()
        }
    }
}
