package com.fuze.features.matches.domain.usecase

import com.fuze.features.matches.domain.model.MatchModel

internal interface GetMatchesUseCase {
    suspend fun invoke(forceRefresh : Boolean) : List<MatchModel>
}