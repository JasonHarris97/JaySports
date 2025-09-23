package com.jasonharris97.jaysports.domain.searchTeams.repository

import com.jasonharris97.jaysports.domain.searchTeams.model.TeamDomainModel
import javax.management.Query

interface TeamsRepository {
    fun getTeams(query: String): List<TeamDomainModel>
}