package com.fuze.features.matches.data.database.dao

import androidx.room.*
import com.fuze.features.matches.data.database.entity.MatchEntity

@Dao
interface MatchDao {

    @Query("SELECT * FROM matches")
    fun getAll(): List<MatchEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertList(list: List<MatchEntity>)

    @Query("SELECT COUNT(*) FROM matches")
    fun getNumOfRows(): Int

    @Query("DELETE FROM matches")
    fun deleteAll(): Int
}