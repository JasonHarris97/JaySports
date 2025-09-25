package com.jasonharris97.jaysports.presentation.teamDetails.viewmodel

import com.jasonharris97.jaysports.domain.core.usecase.UseCaseExecutor
import com.jasonharris97.jaysports.domain.teamDetails.model.TeamDetailsDomainModel
import com.jasonharris97.jaysports.domain.teamDetails.usecase.GetTeamDetailsUseCase
import com.jasonharris97.jaysports.presentation.core.viewmodel.BaseViewModel
import com.jasonharris97.jaysports.presentation.teamDetails.mapper.TeamDetailsDomainToPresentationMapper
import com.jasonharris97.jaysports.presentation.teamDetails.model.TeamDetailsViewState
import com.jasonharris97.jaysports.presentation.teamDetails.notification.TeamDetailsPresentationNotification
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import javax.inject.Inject

@HiltViewModel
class TeamDetailsViewModel @Inject constructor(
    private val getTeamDetailsUseCase: GetTeamDetailsUseCase,
    private val teamDetailsDomainToPresentationMapper: TeamDetailsDomainToPresentationMapper,
    useCaseExecutorProvider: (coroutineScope: CoroutineScope) -> UseCaseExecutor
): BaseViewModel<TeamDetailsViewState, TeamDetailsPresentationNotification>(useCaseExecutorProvider) {
    
    override fun initialState(): TeamDetailsViewState {
        return TeamDetailsViewState()
    }
    
    fun onEntered(teamId: String) {
        updateViewState(TeamDetailsViewState::loading)
        fetchTeamDetails(teamId)
    }
    
    private fun fetchTeamDetails(teamId: String) {
        execute(
            useCase = getTeamDetailsUseCase,
            value = teamId,
            onSuccess = ::showTeamDetails
        )
    }

    private fun showTeamDetails(teamDetails: TeamDetailsDomainModel) {
        updateViewState {
            teamDetailsReady(
                teamDetailsDomainToPresentationMapper.toPresentation(teamDetails)
            )
        }
    }

}