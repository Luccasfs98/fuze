package com.fuze.features.matches.data.remote.model.mapper

import com.fuze.features.matches.data.remote.model.dto.TeamDto
import com.fuze.features.matches.data.remote.model.response.TeamResponse

internal fun List<TeamResponse>.toDto() = this.map {
    TeamDto(
        id = it.team.id,
        imageUrl = it.team.imageUrl,
        name = it.team.name,
    )
}