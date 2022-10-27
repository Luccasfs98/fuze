package com.fuze.ui.components.matchResume

import com.fuze.ui.components.clashTeams.ClashTeamsUiModel

data class MatchResumeUiModel(
    val id: Long,
    val clashTeamsUiModel: ClashTeamsUiModel,
    val leagueUiModel: LeagueUiModel,
    val isLive : Boolean,
    val time : String?
){
    data class LeagueUiModel(
        val id: Long,
        val title : String,
        val imageUrl: String
    )
}