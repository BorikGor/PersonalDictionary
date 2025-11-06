package com.example.personaldictionary.data.db

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

/**
 * Data class: AttemptLog
 * ----------------------
 * What: A single attempt in the mini-game.
 * Why:  We need history to color rows and weight selections.
 * Fields:
 *  - entryId: which Entry was attempted.
 *  - correct: true if matched in game, false otherwise.
 *  - ts: timestamp in millis.
 */
@Entity(tableName = "attempt_logs", indices = [Index("entryId")])
data class AttemptLog(
    @PrimaryKey(autoGenerate = true) val id: Long = 0L,
    val entryId: Long,
    val correct: Boolean,
    val ts: Long = System.currentTimeMillis()
)