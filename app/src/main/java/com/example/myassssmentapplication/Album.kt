package com.example.myassssmentapplication

import java.io.Serializable

/**
 * Data class representing an Album item.
 * Implements [Serializable] so it can be passed between Activities via Intent extras.
 */
data class Album(
    val artistName: String,      // 👨‍🎤 Name of the artist or band
    val albumTitle: String,      // 🎵 Title of the album
    val releaseYear: Int,        // 📆 Year the album was released
    val genre: String,           // 🎧 Genre of the album (e.g., Rock, Pop, Jazz)
    val trackCount: Int,         // 🔢 Number of tracks in the album
    val description: String,     // 📝 Description or summary of the album
    val popularTrack: String     // 🌟 Most popular track from the album
) : Serializable                 // 👈 Enables passing this object between Activities using Intent
