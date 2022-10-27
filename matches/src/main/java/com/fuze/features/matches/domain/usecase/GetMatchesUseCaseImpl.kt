package com.fuze.features.matches.domain.usecase

import com.fuze.features.matches.data.remote.repository.MatchesRepository
import com.fuze.features.matches.domain.mapper.toMatchModel
import com.fuze.features.matches.domain.model.MatchModel
import kotlinx.coroutines.*
import javax.inject.Inject

internal class GetMatchesUseCaseImpl @Inject constructor(
    private val repository: MatchesRepository
) : GetMatchesUseCase {

    override suspend fun invoke(forceRefresh : Boolean) : List<MatchModel> = withContext(Dispatchers.IO){
        awaitAll(
            async {
                repository.getRunningMatches().toMatchModel(isLive = true)
            },
            async {
                repository.getUpcomingMatches().toMatchModel()
            }
        ).flatten()
    }
}