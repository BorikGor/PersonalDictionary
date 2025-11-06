package com.example.personaldictionary.data.db

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

/**
 * Data class: AudioCacheItem
 * --------------------------
 * What: Stores cached audio for a word in a language.
 * Why:  We prefer OGG->MP3->TTS and keep local files for speed.
 * Fields:
 *  - lang: ISO code (e.g., "ru", "he", "mi", "en").
 *  - word: the word as typed.
 *  - audioUrl: source url (e.g., from Wiktionary via Kaikki).
 *  - localPath: path to cached file in app storage.
 *  - format: "ogg" or "mp3".
 *  - sizeBytes: for cache size management.
 *  - lastAccess: for LRU eviction policy.
 */
@Entity(
    tableName = "audio_cache",
    indices = [Index(value = ["lang", "word"], unique = true)]
)
data class AudioCacheItem(
    @PrimaryKey(autoGenerate = true) val id: Long = 0L,
    val lang: String,
    val word: String,
    val audioUrl: String? = null,
    val localPath: String? = null,
    val format: String? = null,
    val sizeBytes: Long = 0L,
    val lastAccess: Long = System.currentTimeMillis()
)