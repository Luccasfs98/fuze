package com.fuze.features.matches.data.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "leagues")
data class LeagueEntity(
    @PrimaryKey
    val id: Long,
    val name : String,
    val serieName : String
)