package com.fuze.features.matches.domain.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * Data class for encapsulating the match data
 */
@Parcelize
data class MatchModel(
    val id: Long,
    val firstOpponent: TeamModel?,
    val secondOpponent: TeamModel?,
    val league: LeagueModel,
    val isLive: Boolean = false,
    val time: String?
) : Parcelable
