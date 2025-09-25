package com.jasonharris97.jaysports.presentation.searchTeams.model

data class SearchTeamsViewState(
    val isLoading: Boolean = false,
    val teams: List<TeamPresentationModel> = emptyList(),
) {
    fun loading(): SearchTeamsViewState = copy(isLoading = true)

    fun withTeams(teams: List<TeamPresentationModel>) = copy(
        isLoading = false,
        teams = teams
    )
}