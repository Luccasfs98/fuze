package com.fuze.features.matches.data.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "teams")
data class TeamEntity (
    @PrimaryKey
    val id: Long,
    val imageUrl: String,
    val name: String,
)