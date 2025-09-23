package com.jasonharris97.jaysports.domain.teamDetails.usecase

import com.jasonharris97.jaysports.domain.core.coroutine.CoroutineContextProvider
import com.jasonharris97.jaysports.domain.core.usecase.BackgroundExecutingUseCase
import com.jasonharris97.jaysports.domain.teamDetails.model.TeamDetailsDomainModel
import com.jasonharris97.jaysports.domain.teamDetails.repository.TeamDetailsRepository

class GetTeamDetailsUseCase(
    private val teamDetailsRepository: TeamDetailsRepository,
    coroutineContextProvider: CoroutineContextProvider,
) : BackgroundExecutingUseCase<String, TeamDetailsDomainModel>(
    coroutineContextProvider
) {
    override fun executeInBackground(request: String): TeamDetailsDomainModel {
        return teamDetailsRepository.getTeamDetails(request)
    }
}