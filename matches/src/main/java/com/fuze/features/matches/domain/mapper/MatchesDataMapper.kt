package com.fuze.features.matches.domain.mapper

import android.os.Build
import androidx.annotation.RequiresApi
import com.fuze.features.matches.data.remote.model.response.LeagueResponse
import com.fuze.features.matches.data.remote.model.response.MatchesResponse
import com.fuze.features.matches.data.remote.model.response.TeamResponse
import com.fuze.features.matches.domain.model.LeagueModel
import com.fuze.features.matches.domain.model.MatchModel
import com.fuze.features.matches.domain.model.TeamModel
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter


internal fun List<MatchesResponse>.toMatchModel(isLive : Boolean = false) = this.map {
    MatchModel(
        id = it.id,
        firstOpponent = it.teamsList.firstOrNull()?.toTeamModel(),
        secondOpponent = it.teamsList.getOrNull(1)?.toTeamModel(),
        league = it.league.toLeagueModel(it.serie.fullName),
        time = it.beginAt.formatDate(),
        isLive = isLive,
    )
}

@RequiresApi(Build.VERSION_CODES.O)
private fun String?.formatDate(): String {
    this?.let {
        try {
            val format = DateTimeFormatter.ofPattern("E, HH:mm")
            val d: ZonedDateTime = ZonedDateTime.parse(this)
            return d.format(format)
        } catch (e:Exception){
            e.printStackTrace()
        }

    }
    return ""
}

internal fun TeamResponse.toTeamModel() =
    TeamModel(
        id = this.team.id,
        imageUrl = this.team.imageUrl,
        name = this.team.name
    )

internal fun LeagueResponse.toLeagueModel(fullName: String) =
    LeagueModel(
        id = this.id,
        imgUrl = this.imgUrl,
        name = "${this.name} $fullName"
    )



