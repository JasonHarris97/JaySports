package com.jasonharris97.jaysports.presentation.teamDetails.viewmodel

import com.jasonharris97.jaysports.domain.core.usecase.UseCaseExecutor
import com.jasonharris97.jaysports.domain.teamDetails.usecase.GetTeamDetailsUseCase
import com.jasonharris97.jaysports.presentation.core.viewmodel.BaseViewModel
import kotlinx.coroutines.CoroutineScope

class TeamDetailsViewModel @Inject constructor(
    private val getTeamDetailsUseCase: GetTeamDetailsUseCase,
    private val teamDetailsDomainToPresentationMapper: TeamDetailsDomainToPresentationMapper,
    useCaseExecutorProvider: (coroutineScope: CoroutineScope) -> UseCaseExecutor
): BaseViewModel