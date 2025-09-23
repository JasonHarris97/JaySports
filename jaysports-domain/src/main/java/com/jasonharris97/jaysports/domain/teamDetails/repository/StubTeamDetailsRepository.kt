package com.jasonharris97.jaysports.domain.teamDetails.repository

import com.jasonharris97.jaysports.domain.teamDetails.model.TeamDetailsDomainModel

class StubTeamDetailsRepository : TeamDetailsRepository {
    override fun getTeamDetails(teamId: String): TeamDetailsDomainModel {
        return TeamDetailsDomainModel(
            id = "1",
            name = "Manchester United",
            code = "MUN",
            country = "England",
            founded = 1997,
            logoUrl = "https://url.com"
        )
    }
}