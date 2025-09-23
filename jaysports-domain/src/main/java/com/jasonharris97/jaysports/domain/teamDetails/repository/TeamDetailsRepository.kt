package com.jasonharris97.jaysports.domain.teamDetails.repository

import com.jasonharris97.jaysports.domain.teamDetails.model.TeamDetailsDomainModel

interface TeamDetailsRepository {
    fun getTeamDetails(teamId: String): TeamDetailsDomainModel
}