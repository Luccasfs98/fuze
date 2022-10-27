package com.fuze.features.matches.presentation.list.mapper

import com.fuze.features.matches.domain.model.LeagueModel
import com.fuze.features.matches.domain.model.MatchModel
import com.fuze.features.matches.domain.model.TeamModel
import com.fuze.ui.components.clashTeams.ClashTeamsUiModel
import com.fuze.ui.components.matchResume.MatchResumeUiModel
import com.fuze.ui.components.team.TeamUiModel

fun MatchModel.toMatchResumeUiModel() =
    MatchResumeUiModel(
        id = this.id,
        clashTeamsUiModel = toClashTeamsUiModel(
            this.firstOpponent,
            this.secondOpponent
        ),
        leagueUiModel = this.league.toLeagueUiModel(),
        isLive = this.isLive,
        time = this.time
    )

fun toClashTeamsUiModel(
    firstOpponent: TeamModel?,
    secondOpponent: TeamModel?
) =
    ClashTeamsUiModel(
        firstTeam = firstOpponent?.toTeamUiModel(),
        secondTeam = secondOpponent?.toTeamUiModel()
    )

fun TeamModel.toTeamUiModel() =
    TeamUiModel(
        id = this.id,
        name = this.name,
        imageUrl = this.imageUrl
    )

fun LeagueModel.toLeagueUiModel() = MatchResumeUiModel.LeagueUiModel(
    imageUrl = this.imgUrl.orEmpty(),
    id = this.id,
    title = this.name
)






