package com.example.personaldictionary.data.db

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import android.content.Context

/**
 * Room: AppDatabase
 * -----------------
 * What: The main "house" of our DB.
 * Why:  Room needs a single access point and versioning.
 * Entities: Dictionary, Entry, AttemptLog, AudioCacheItem.
 * Version: Start with 1 (increase on schema changes).
 * Provides: dao() - our DictionaryDao.
 */
@Database(
    entities = [
        Dictionary::class,
        Entry::class,
        AttemptLog::class,
        AudioCacheItem::class
    ],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun dao(): DictionaryDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        /**
         * get(context)
         * ------------
         * What: Returns a singleton DB instance.
         * Uses: Room.databaseBuilder, appContext to avoid leaks.
         * Vars: local ref 'inst' for double-checked locking.
         */
        fun get(context: Context): AppDatabase {
            val inst = INSTANCE
            if (inst != null) return inst
            synchronized(this) {
                val created = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "personal_dictionary.db"
                ).build()
                INSTANCE = created
                return created
            }
        }
    }
}