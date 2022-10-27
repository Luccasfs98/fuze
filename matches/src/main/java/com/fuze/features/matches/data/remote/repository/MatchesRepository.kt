package com.fuze.features.matches.data.remote.repository

import com.fuze.features.matches.data.remote.model.response.MatchesResponse


internal interface MatchesRepository {
    suspend fun getUpcomingMatches() : List<MatchesResponse>
    suspend fun getRunningMatches() : List<MatchesResponse>
}