package com.jasonharris97.jaysports.presentation.searchTeams.viewmodel

import com.jasonharris97.jaysports.presentation.core.viewmodel.BaseViewModel

class SearchTeamsViewModel() : BaseViewModel<SearchDetailsViewState, Unit>(){
    fun onSearchQueryChanged(query: String) {

    }

    fun onTeamSelected(teamId: String) {
        navigateTo(TeamDetails(teamId))
    }
}