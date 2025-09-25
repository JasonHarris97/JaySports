package com.jasonharris97.jaysports.presentation.searchTeams.destination

import com.jasonharris97.jaysports.presentation.core.model.PresentationDestination

sealed interface SearchTeamsPresentationDestination : PresentationDestination {
    data class TeamDetails(
        val teamId: String
    ) : SearchTeamsPresentationDestination
}