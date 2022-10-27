package com.fuze.features.matches.data.remote.model.dto

internal data class MatchDto(
    val id: Long,
    val league: LeagueDto,
    val teams: List<TeamDto>,
    val beginAt: String?,
)