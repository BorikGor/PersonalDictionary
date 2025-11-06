package com.example.personaldictionary.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

/**
 * DAO: DictionaryDao
 * ------------------
 * What: Door to read/write dictionaries and entries.
 * Why:  Room needs DAO to generate safe SQL.
 * Methods:
 *  - insertDictionary: adds a dictionary.
 *  - updateDictionary: updates fields (e.g., name).
 *  - getAllDictionaries: list for Home screen.
 *  - insertEntry/insertEntries: add one or many entries.
 *  - getEntriesForDict: list of entries for one dictionary.
 *  - logAttempt: add a history record.
 *  - getAttemptsForEntry: read history to compute colors.
 */
@Dao
interface DictionaryDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDictionary(d: Dictionary): Long

    @Update
    suspend fun updateDictionary(d: Dictionary)

    @Query("SELECT * FROM dictionaries ORDER BY name")
    suspend fun getAllDictionaries(): List<Dictionary>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertEntry(e: Entry): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertEntries(list: List<Entry>): List<Long>

    @Query(
        "SELECT * FROM entries WHERE dictionaryId = :dictId " +
                "ORDER BY sourceWord COLLATE NOCASE"
    )
    suspend fun getEntriesForDict(dictId: Long): List<Entry>

    @Insert
    suspend fun logAttempt(a: AttemptLog): Long

    @Query(
        "SELECT * FROM attempt_logs WHERE entryId = :entryId " +
                "ORDER BY ts DESC LIMIT :limit"
    )
    suspend fun getAttemptsForEntry(entryId: Long, limit: Int = 5): List<AttemptLog>
}