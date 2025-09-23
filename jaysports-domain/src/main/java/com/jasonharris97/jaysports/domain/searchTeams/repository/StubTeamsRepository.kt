package com.jasonharris97.jaysports.domain.searchTeams.repository

import com.jasonharris97.jaysports.domain.searchTeams.model.TeamDomainModel

class StubTeamsRepository : TeamsRepository {
    override fun getTeams(query: String): List<TeamDomainModel> {
        return listOf(
            TeamDomainModel(
                id = "1",
                name = "Manchester United",
                logoUrl = "https://url.com"
            )
        )
    }
}