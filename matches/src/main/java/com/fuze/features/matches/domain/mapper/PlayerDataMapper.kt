package com.fuze.features.matches.domain.mapper

import com.fuze.features.matches.data.remote.model.response.PlayersResponse
import com.fuze.features.matches.domain.model.PlayerModel

internal fun List<PlayersResponse>.toPlayersModel(side : String) = this.mapIndexed { index, player ->
    PlayerModel(
        imgUrl = player.imgUrl,
        fullName = "${player.name} ${player.lastName}",
        nickname = player.nickname,
        side = side
    )
}