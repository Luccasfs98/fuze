package com.fuze.features.matches.domain.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class LeagueModel(
    val id: Long,
    val imgUrl: String?,
    val name: String,
) : Parcelable
