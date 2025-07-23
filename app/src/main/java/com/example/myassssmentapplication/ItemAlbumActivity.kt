package com.example.myassssmentapplication

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

/**
 * ItemAlbumActivity
 *
 * This activity displays a layout named `item_album.xml`, typically used for a single album item UI.
 * It uses edge-to-edge support and adjusts padding based on system bars (status bar, navigation bar).
 *
 * Note: This activity is *not commonly used* directly if `item_album.xml` is a RecyclerView item layout.
 */
class ItemAlbumActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // ✅ Enables edge-to-edge layout drawing (status bar and nav bar transparency)
        enableEdgeToEdge()

        // 🖼️ Set the content view using layout file: res/layout/item_album.xml
        // ⚠️ Usually, this layout is used for individual RecyclerView items, not full activities.
        setContentView(R.layout.item_album)

        // 🧩 Adjust padding to avoid system bars (navigation bar/status bar overlapping content)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())

            // 💡 Apply padding only where system bars overlap (top, bottom, left, right)
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)

            insets // 🔁 Return insets so system deals with the rest
        }
    }
}
