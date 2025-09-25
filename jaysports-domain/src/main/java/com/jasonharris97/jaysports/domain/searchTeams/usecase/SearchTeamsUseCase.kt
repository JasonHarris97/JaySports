package com.jasonharris97.jaysports.domain.searchTeams.usecase

import com.jasonharris97.jaysports.domain.core.coroutine.CoroutineContextProvider
import com.jasonharris97.jaysports.domain.core.usecase.BackgroundExecutingUseCase
import com.jasonharris97.jaysports.domain.searchTeams.model.TeamDomainModel
import com.jasonharris97.jaysports.domain.searchTeams.repository.TeamsRepository

class SearchTeamsUseCase(
    private val teamDetailsRepository: TeamsRepository,
    coroutineContextProvider: CoroutineContextProvider,
) : BackgroundExecutingUseCase<String, List<TeamDomainModel>>(
    coroutineContextProvider
){
    override fun executeInBackground(request: String): List<TeamDomainModel> {
       return teamDetailsRepository.getTeams(query = request)
    }
}