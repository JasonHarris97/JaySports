package com.jasonharris97.jaysports.presentation.searchTeams.viewmodel

import com.jasonharris97.jaysports.domain.core.usecase.UseCaseExecutor
import com.jasonharris97.jaysports.domain.searchTeams.model.TeamDomainModel
import com.jasonharris97.jaysports.domain.searchTeams.usecase.SearchTeamsUseCase
import com.jasonharris97.jaysports.presentation.core.viewmodel.BaseViewModel
import com.jasonharris97.jaysports.presentation.searchTeams.mapper.TeamDomainToPresentationMapper
import com.jasonharris97.jaysports.presentation.searchTeams.navigation.SearchTeamsPresentationDestination
import com.jasonharris97.jaysports.presentation.searchTeams.model.SearchTeamsViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import javax.inject.Inject

@HiltViewModel
class SearchTeamsViewModel @Inject constructor(
    private val searchTeamsUseCase: SearchTeamsUseCase,
    private val teamDomainToPresentationMapper: TeamDomainToPresentationMapper,
    useCaseExecutorProvider: (coroutineScope: CoroutineScope) -> UseCaseExecutor
) : BaseViewModel<SearchTeamsViewState, Unit>(useCaseExecutorProvider){

    fun onEntered() {
        onSearchQueryChanged("")
    }

    fun onSearchQueryChanged(query: String) {
        updateViewState(SearchTeamsViewState::loading)
        execute(
            useCase = searchTeamsUseCase,
            value = query,
            onSuccess = ::presentTeams
        )
    }

    private fun presentTeams(teams: List<TeamDomainModel>) {
        updateViewState {
            withTeams(
                teams = teams.map(teamDomainToPresentationMapper::toPresentation)
            )
        }
    }

    fun onTeamSelected(teamId: String) {
        navigateTo(SearchTeamsPresentationDestination.TeamDetails(teamId))
    }

    override fun initialState(): SearchTeamsViewState {
        return SearchTeamsViewState()
    }
}