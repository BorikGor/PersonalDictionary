package com.example.personaldictionary.data.db

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

/**
 * Data class: Entry
 * -----------------
 * What: One row in the 2-column table.
 * Why:  Stores source word and its chosen translation.
 * Fields:
 *  - dictionaryId: foreign key to Dictionary (not enforced here,
 *    can be enforced via @ForeignKey if needed).
 *  - sourceWord: word in <yourLanguage>.
 *  - targetWord: chosen translation (or custom).
 *  - isCustomTarget: true if targetWord typed by user.
 *  - ipa: phonemic string (IPA or ARPAbet for English).
 *  - createdAt/updatedAt: timestamps.
 *  - last5: compact history for last 5 attempts ("10110"), where
 *    '1' = correct, '0' = wrong, newest at the end. Green fill
 *    = "11111".
 */
@Entity(
    tableName = "entries",
    indices = [Index("dictionaryId"), Index("sourceWord"), Index("targetWord")]
)
data class Entry(
    @PrimaryKey(autoGenerate = true) val id: Long = 0L,
    val dictionaryId: Long,
    val sourceWord: String,
    val targetWord: String,
    val isCustomTarget: Boolean = false,
    val ipa: String? = null,
    val createdAt: Long = System.currentTimeMillis(),
    val updatedAt: Long = System.currentTimeMillis(),
    val last5: String = ""  // e.g., "111", "10110", etc.
)