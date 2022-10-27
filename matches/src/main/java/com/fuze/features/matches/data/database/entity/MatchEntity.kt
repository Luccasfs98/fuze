package com.fuze.features.matches.data.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "matches")
data class MatchEntity (
        @PrimaryKey
        val id: Long,
        val firstTeamId: Long,
        val secondTeamId: Long,
        val leagueId: Long,
        val isLive: Boolean,
        val time : String
)