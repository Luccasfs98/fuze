package com.fuze.features.matches.presentation.list.adapter

import android.view.LayoutInflater
import com.fuze.commons.base.BaseViewHolder
import com.fuze.features.matches.databinding.ItemMatchLayoutBinding
import com.fuze.features.matches.domain.model.MatchModel
import com.fuze.features.matches.presentation.list.mapper.toMatchResumeUiModel

class MatchItemViewHolder(
    inflater: LayoutInflater
) : BaseViewHolder<ItemMatchLayoutBinding>(
binding = ItemMatchLayoutBinding.inflate(inflater)
) {

    fun bind(matchModel: MatchModel, click: ((MatchModel) -> Unit)?) {
        binding.root.setOnClickListener {
            click?.invoke(matchModel)
        }
        binding.matchResume.model = matchModel.toMatchResumeUiModel()
    }
}