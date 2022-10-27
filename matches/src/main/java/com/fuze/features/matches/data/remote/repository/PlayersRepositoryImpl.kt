package com.fuze.features.matches.data.remote.repository

import com.fuze.core.data.base.BaseRepository
import com.fuze.core.data.exceptions.EmptyResponseBodyException
import com.fuze.core.data.exceptions.TeamIdNullException
import com.fuze.features.matches.data.remote.MatchApi
import com.fuze.features.matches.data.remote.PlayerApi
import com.fuze.features.matches.data.remote.model.response.MatchesResponse
import com.fuze.features.matches.data.remote.model.response.OpponentsResponse
import com.fuze.features.matches.data.remote.model.response.PlayersResponse
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.merge
import javax.inject.Inject

/**
 * Implementation of [PlayersRepository]
 */
internal class PlayersRepositoryImpl @Inject constructor(
    private val api: PlayerApi
) : PlayersRepository, BaseRepository() {

    override suspend fun getOpponentsByMatchId(matchId : Long) : List<OpponentsResponse.OpponentList> {
        try {
            val response = api.getOpponentsByMatchId(matchId)
            if (response.body() != null && !response.body()?.opponentsResponse.isNullOrEmpty()) return response.body()!!.opponentsResponse else throw EmptyResponseBodyException()
        } catch (ex: Exception) {
            throw parseErrorResponse(ex)
        }
    }
}