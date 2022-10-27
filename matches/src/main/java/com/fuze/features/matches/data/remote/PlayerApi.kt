package com.fuze.features.matches.data.remote

import com.fuze.features.matches.data.remote.model.response.OpponentsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Interface representing API endpoints for players
 */
internal interface PlayerApi {

    @GET("/matches/{id}/opponents")
    suspend fun getOpponentsByMatchId(
        @Path("id") matchId: Long
    ): Response<OpponentsResponse>

}