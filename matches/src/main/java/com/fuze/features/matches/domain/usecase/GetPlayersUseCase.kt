package com.fuze.features.matches.domain.usecase

import com.fuze.features.matches.domain.model.PlayerModel

internal interface GetPlayersUseCase {
    suspend fun invoke(matchId: Long) : List<PlayerModel>
}