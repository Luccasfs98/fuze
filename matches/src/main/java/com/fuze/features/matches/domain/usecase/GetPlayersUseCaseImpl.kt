package com.fuze.features.matches.domain.usecase

import com.fuze.features.matches.data.remote.repository.PlayersRepository
import com.fuze.features.matches.domain.mapper.toPlayersModel
import com.fuze.features.matches.domain.model.PlayerModel
import kotlinx.coroutines.coroutineScope
import javax.inject.Inject

internal class GetPlayersUseCaseImpl @Inject constructor(
    private val repository: PlayersRepository
) : GetPlayersUseCase {

    override suspend fun invoke(matchId: Long) : List<PlayerModel> = coroutineScope {
        val opponentList = repository.getOpponentsByMatchId(matchId)
        val leftSide = opponentList[0].players?.toPlayersModel("left")
        val rightSide = opponentList[1].players?.toPlayersModel("right")

        val mergedOpponents = ArrayList<PlayerModel>(10)
        leftSide?.getOrNull(0)?.let { mergedOpponents.add(it) }
        rightSide?.getOrNull(0)?.let { mergedOpponents.add(it) }

        leftSide?.getOrNull(1)?.let { mergedOpponents.add(it) }
        rightSide?.getOrNull(1)?.let { mergedOpponents.add(it) }

        leftSide?.getOrNull(2)?.let { mergedOpponents.add(it) }
        rightSide?.getOrNull(2)?.let { mergedOpponents.add(it) }

        leftSide?.getOrNull(3)?.let { mergedOpponents.add(it) }
        rightSide?.getOrNull(3)?.let { mergedOpponents.add(it) }

        leftSide?.getOrNull(4)?.let { mergedOpponents.add(it) }
        rightSide?.getOrNull(4)?.let { mergedOpponents.add(it) }

        mergedOpponents.toList()
    }
}