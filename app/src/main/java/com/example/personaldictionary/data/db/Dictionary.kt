package com.example.personaldictionary.data.db

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Data class: Dictionary
 * ----------------------
 * What: Represents one user dictionary.
 * Why:  We need a table to group entries by dictionary.
 * Fields:
 *  - id: auto-generated primary key.
 *  - name: UI name (e.g., "English", "Hebrew", "Maori").
 *  - sourceLang: ISO code for left column (e.g., "ru").
 *  - targetLang: ISO code or "custom:<name>" for right column.
 *  - createdAt/updatedAt: timestamps as millis since epoch.
 */
@Entity(tableName = "dictionaries")
data class Dictionary(
    @PrimaryKey(autoGenerate = true) val id: Long = 0L,
    val name: String,
    val sourceLang: String,
    val targetLang: String,
    val createdAt: Long = System.currentTimeMillis(),
    val updatedAt: Long = System.currentTimeMillis()
)