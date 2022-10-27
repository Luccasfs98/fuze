package com.fuze.commons.extensions

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding

inline fun <T : ViewBinding> ViewGroup.viewBinding(
    crossinline bindingInflater: (LayoutInflater, ViewGroup, Boolean) -> T,
) = lazy(LazyThreadSafetyMode.NONE) {
    bindingInflater.invoke(LayoutInflater.from(this.context), this, true)
}