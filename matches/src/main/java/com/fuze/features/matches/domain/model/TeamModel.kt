package com.fuze.features.matches.domain.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class TeamModel(
    val id: Long,
    val imageUrl: String?,
    val name: String
) : Parcelable