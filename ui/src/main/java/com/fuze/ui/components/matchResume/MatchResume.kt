package com.fuze.ui.components.matchResume

import android.content.Context
import android.util.AttributeSet
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import com.fuze.commons.extensions.loadImageFromUrl
import com.fuze.commons.extensions.viewBinding
import com.fuze.ui.R
import com.fuze.ui.databinding.MatchResumeLayoutBinding

class MatchResume @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0,
) : ConstraintLayout(context, attrs, defStyleAttr) {

    private val binding by viewBinding(MatchResumeLayoutBinding::inflate)

    var model: MatchResumeUiModel? = null
        set(value){
            field = value
            value?.let { matchResumeModel ->
                binding.clashTeams.model = matchResumeModel.clashTeamsUiModel
                binding.leagueImg.loadImageFromUrl(matchResumeModel.leagueUiModel.imageUrl, fallBackImage = ContextCompat.getDrawable(context, R.drawable.rounded_grey_shape))
                binding.leagueTitle.text = matchResumeModel.leagueUiModel.title

                if (matchResumeModel.isLive){
                    binding.timeTextView.apply {
                        text = resources.getString(R.string.in_live)
                        background = ContextCompat.getDrawable(context, R.drawable.time_red_shape);
                    }
                } else {
                    binding.timeTextView.background = ContextCompat.getDrawable(context, R.drawable.time_grey_shape);
                    matchResumeModel.time?.let {
                        binding.timeTextView.text = it
                    }
                }
            }
        }
}