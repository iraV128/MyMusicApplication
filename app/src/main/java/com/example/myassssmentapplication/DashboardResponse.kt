package com.example.myassssmentapplication

/**
 * Data class representing the API response from the dashboard endpoint.
 *
 * @param entities A list of Album objects returned from the API.
 * @param entityTotal The total number of albums available.
 */
data class DashboardResponse(
    val entities: List<Album>,     // 📦 List of albums (data displayed in UI)
    val entityTotal: Int           // 🔢 Total number of albums (can be used for statistics or paging)
)
