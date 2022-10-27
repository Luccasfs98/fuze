package com.fuze.features.matches.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.fuze.features.matches.data.database.dao.MatchDao
import com.fuze.features.matches.data.database.entity.MatchEntity

@Database(
        entities = [MatchEntity::class],
        version = 1,
        exportSchema = false
)

abstract class MatchesDatabase : RoomDatabase() {
    abstract fun matchDao(): MatchDao
}
