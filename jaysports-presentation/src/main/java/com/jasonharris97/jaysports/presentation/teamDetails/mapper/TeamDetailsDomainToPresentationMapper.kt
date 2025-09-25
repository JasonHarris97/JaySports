package com.jasonharris97.jaysports.presentation.teamDetails.mapper

import com.jasonharris97.jaysports.domain.teamDetails.model.TeamDetailsDomainModel
import com.jasonharris97.jaysports.presentation.teamDetails.model.TeamDetailsPresentationModel

class TeamDetailsDomainToPresentationMapper() {
    fun toPresentation(input: TeamDetailsDomainModel) : TeamDetailsPresentationModel {
        return TeamDetailsPresentationModel(
            id = input.id,
            name = input.name,
            code = input.code,
            country = input.country,
            founded = input.founded,
            logoUrl = input.logoUrl
        )
    }
}