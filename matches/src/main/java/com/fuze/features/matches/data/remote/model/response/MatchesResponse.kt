package com.fuze.features.matches.data.remote.model.response

import com.google.gson.annotations.SerializedName

/**
 * Class to get the matches API response
 */
internal data class MatchesResponse(
        @SerializedName("id") val id: Long,
        @SerializedName("begin_at") val beginAt: String?,
        @SerializedName("league") val league: LeagueResponse,
        @SerializedName("opponents") val teamsList: List<TeamResponse>,
        @SerializedName("serie") val serie: SeriesResponse
)