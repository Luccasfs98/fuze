package com.fuze.commons.extensions

import android.graphics.drawable.Drawable
import android.widget.ImageView
import coil.load
import coil.transform.CircleCropTransformation

fun ImageView.loadImageFromUrl(
    url: String?,
    fallBackImage: Drawable? = null,
    placeholder: Drawable? = null,
    crossfade: Boolean = true
) {
    url?.let { it ->
        this.load(it){
            crossfade(crossfade)
            placeholder(placeholder)
            error(fallBackImage)
        }
    } ?: setImageDrawable(fallBackImage)
}
