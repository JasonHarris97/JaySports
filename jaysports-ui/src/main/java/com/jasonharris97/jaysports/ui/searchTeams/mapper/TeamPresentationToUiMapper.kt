package com.jasonharris97.jaysports.ui.searchTeams.mapper

import com.jasonharris97.jaysports.presentation.searchTeams.model.TeamPresentationModel
import com.jasonharris97.jaysports.ui.searchTeams.model.TeamUiModel

class TeamPresentationToUiMapper {

    fun toUi(team: TeamPresentationModel): TeamUiModel {
        return TeamUiModel(
            id = team.id,
            name = team.name,
            logoUrl = team.logoUrl
        )
    }
}