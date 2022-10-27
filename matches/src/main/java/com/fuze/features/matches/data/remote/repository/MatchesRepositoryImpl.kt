package com.fuze.features.matches.data.remote.repository

import com.fuze.core.data.base.BaseRepository
import com.fuze.core.data.exceptions.EmptyResponseBodyException
import com.fuze.features.matches.data.remote.MatchApi
import com.fuze.features.matches.data.remote.model.response.MatchesResponse
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.merge
import javax.inject.Inject

/**
 * Implementation of [MatchesRepository]
 */
internal class MatchesRepositoryImpl @Inject constructor(
    private val api: MatchApi
) : MatchesRepository, BaseRepository() {

    override suspend fun getRunningMatches() : List<MatchesResponse> {
        try {
            val response = api.getRunningMatches()

            if (response.body() != null) return response.body()!! else throw EmptyResponseBodyException()
        } catch (ex: Exception) {
            throw parseErrorResponse(ex)
        }
    }
    override suspend fun getUpcomingMatches() : List<MatchesResponse> {
        try {
            val response = api.getUpcomingMatches()

            if (response.body() != null) return response.body()!! else throw EmptyResponseBodyException()
        } catch (ex: Exception) {
            throw parseErrorResponse(ex)
        }
    }
}