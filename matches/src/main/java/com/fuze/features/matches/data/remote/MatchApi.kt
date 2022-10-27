package com.fuze.features.matches.data.remote

import com.fuze.features.matches.data.remote.model.response.MatchesResponse
import com.fuze.features.matches.data.remote.model.response.PlayersResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Interface representing API endpoints for matches
 */
internal interface MatchApi {

    @GET("/csgo/matches/upcoming?page=1")
    suspend fun getUpcomingMatches(): Response<List<MatchesResponse>>

    @GET("/csgo/matches/running?page=1")
    suspend fun getRunningMatches(): Response<List<MatchesResponse>>
}