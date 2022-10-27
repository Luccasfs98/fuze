package com.fuze.features.matches.data.remote.model.mapper

import com.fuze.features.matches.data.remote.model.dto.LeagueDto
import com.fuze.features.matches.data.remote.model.dto.TeamDto
import com.fuze.features.matches.data.remote.model.response.LeagueResponse
import com.fuze.features.matches.data.remote.model.response.TeamResponse

internal fun LeagueResponse.toDto() =
    LeagueDto(
        id = this.id,
        imgUrl = this.imgUrl,
        name = this.name,
    )
