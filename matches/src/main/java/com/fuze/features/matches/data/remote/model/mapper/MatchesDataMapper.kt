package com.fuze.features.matches.data.remote.model.mapper

import com.fuze.features.matches.data.remote.model.dto.MatchDto
import com.fuze.features.matches.data.remote.model.response.MatchesResponse

internal fun List<MatchesResponse>.toDto() = this.map {
    MatchDto(
        id = it.id,
        beginAt = it.beginAt,
        league = it.league.toDto(),
        teams = it.teamsList.toDto(),
    )
}
