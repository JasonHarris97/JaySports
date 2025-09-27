package com.jasonharris97.jaysports.presentation.searchTeams.navigation

import com.jasonharris97.jaysports.presentation.core.model.PresentationDestination

sealed interface SearchTeamsPresentationDestination : PresentationDestination {
    data class TeamDetails(
        val teamId: String
    ) : SearchTeamsPresentationDestination
}