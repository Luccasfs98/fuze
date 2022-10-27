package com.fuze.ui.components.player

import android.content.Context
import android.util.AttributeSet
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import com.fuze.commons.extensions.loadImageFromUrl
import com.fuze.commons.extensions.viewBinding
import com.fuze.ui.R
import com.fuze.ui.databinding.LeftPlayerLayoutBinding
import com.fuze.ui.databinding.RightPlayerLayoutBinding

class Player @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0,
) : ConstraintLayout(context, attrs, defStyleAttr) {


    var model: PlayerUiModel? = null
        set(value){
            field = value
            value?.let { player ->
                if (player.side == "left"){
                    val binding by viewBinding(LeftPlayerLayoutBinding::inflate)
                    binding.playerImg.loadImageFromUrl(player.imgUrl, fallBackImage = ContextCompat.getDrawable(context, R.drawable.rounded_grey_shape))

                    player.nickname.let {
                        binding.playerNickname.text = it
                    }
                    player.fullName.let {
                        binding.playerFullName.text = it
                    }
                } else {
                    val binding by viewBinding(RightPlayerLayoutBinding::inflate)
                    binding.playerImg.loadImageFromUrl(player.imgUrl, fallBackImage = ContextCompat.getDrawable(context, R.drawable.rounded_grey_shape))
                    binding.playerNickname.text = player.nickname
                    binding.playerFullName.text = player.fullName
                }
            }
        }
}