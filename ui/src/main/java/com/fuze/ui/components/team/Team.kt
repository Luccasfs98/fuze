package com.fuze.ui.components.team

import android.content.Context
import android.util.AttributeSet
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import com.fuze.commons.extensions.loadImageFromUrl
import com.fuze.commons.extensions.viewBinding
import com.fuze.ui.R
import com.fuze.ui.databinding.TeamComponentLayoutBinding

class Team @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0,
) : ConstraintLayout(context, attrs, defStyleAttr) {

    private val binding by viewBinding(TeamComponentLayoutBinding::inflate)

    var model: TeamUiModel? = null
        set(value){
            field = value
            value?.let { team ->
                binding.teamImg.loadImageFromUrl(team.imageUrl, fallBackImage = ContextCompat.getDrawable(context, R.drawable.rounded_grey_shape))
                binding.teamName.text = team.name
            }
        }
}