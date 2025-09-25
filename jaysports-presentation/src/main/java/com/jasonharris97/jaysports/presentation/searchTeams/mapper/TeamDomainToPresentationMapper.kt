package com.jasonharris97.jaysports.presentation.searchTeams.mapper

import com.jasonharris97.jaysports.domain.searchTeams.model.TeamDomainModel
import com.jasonharris97.jaysports.presentation.searchTeams.model.TeamPresentationModel

class TeamDomainToPresentationMapper {
    fun toPresentation(team: TeamDomainModel) : TeamPresentationModel {
        return TeamPresentationModel(
            id = team.id,
            name = team.name,
            logoUrl = team.logoUrl
        )
    }
}