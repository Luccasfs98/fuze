package com.fuze.features.matches.presentation.detail.mapper

import com.fuze.features.matches.domain.model.PlayerModel
import com.fuze.ui.components.player.PlayerUiModel

fun PlayerModel.toPlayerUiModel() =
    PlayerUiModel(
        nickname = this.nickname,
        fullName = this.fullName,
        imgUrl = this.imgUrl,
        side = this.side
    )






