package com.jasonharris97.jaysports.presentation.teamDetails.model

data class TeamDetailsViewState(
    val isLoading: Boolean = false,
    val teamDetails: TeamDetailsPresentationModel? = null,
) {
    fun loading() = copy(isLoading = true)

    fun teamDetailsReady(
        teamDetails: TeamDetailsPresentationModel
    ) = copy(isLoading = false, teamDetails = teamDetails)
}
