package com.fuze.ui.components.clashTeams

import android.content.Context
import android.util.AttributeSet
import androidx.constraintlayout.widget.ConstraintLayout
import com.fuze.commons.extensions.loadImageFromUrl
import com.fuze.commons.extensions.viewBinding
import com.fuze.ui.components.team.TeamUiModel
import com.fuze.ui.databinding.ClashTeamsLayoutBinding
import com.fuze.ui.databinding.TeamComponentLayoutBinding

class ClashTeams @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0,
) : ConstraintLayout(context, attrs, defStyleAttr) {

    private val binding by viewBinding(ClashTeamsLayoutBinding::inflate)

    var model: ClashTeamsUiModel? = null
        set(value){
            field = value
            value?.let { clash ->
                binding.firstTeam.model = clash.firstTeam
                binding.secondTeam.model = clash.secondTeam
            }
        }
}