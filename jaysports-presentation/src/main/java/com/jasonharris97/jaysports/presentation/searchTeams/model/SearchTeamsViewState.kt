package com.jasonharris97.jaysports.presentation.searchTeams.model

data class SearchTeamsViewState(
    val isLoading: Boolean = false,
    val searchQuery: String = "",
    val teams: List<TeamPresentationModel> = emptyList(),
) {
    fun newSearch(query: String): SearchTeamsViewState = copy(
        isLoading = true,
        searchQuery = query
    )

    fun withTeams(teams: List<TeamPresentationModel>) = copy(
        isLoading = false,
        teams = teams
    )
}