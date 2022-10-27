package com.fuze.features.matches.presentation.detail.adapter

import android.view.LayoutInflater
import com.fuze.commons.base.BaseViewHolder
import com.fuze.features.matches.databinding.ItemPlayerLayoutBinding
import com.fuze.features.matches.domain.model.PlayerModel
import com.fuze.features.matches.presentation.detail.mapper.toPlayerUiModel

class PlayerItemViewHolder(
    inflater: LayoutInflater
) : BaseViewHolder<ItemPlayerLayoutBinding>(
    binding = ItemPlayerLayoutBinding.inflate(inflater)
) {

    fun bind(matchModel: PlayerModel) {
        binding.playerData.model = matchModel.toPlayerUiModel()
    }
}