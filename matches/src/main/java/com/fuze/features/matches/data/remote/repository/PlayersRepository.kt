package com.fuze.features.matches.data.remote.repository

import com.fuze.features.matches.data.remote.model.response.OpponentsResponse

internal interface PlayersRepository {
    suspend fun getOpponentsByMatchId(matchId: Long) : List<OpponentsResponse.OpponentList>}