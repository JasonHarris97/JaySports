package com.jasonharris97.jaysports.app.di.searchTeams

import com.jasonharris97.jaysports.domain.core.coroutine.CoroutineContextProvider
import com.jasonharris97.jaysports.domain.searchTeams.repository.TeamsRepository
import com.jasonharris97.jaysports.domain.searchTeams.usecase.SearchTeamsUseCase
import com.jasonharris97.jaysports.presentation.searchTeams.mapper.TeamDomainToPresentationMapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class SearchTeamsPresentationModule(){

    @Provides
    fun providesTeamsUseCase(
        teamsRepository: TeamsRepository,
        coroutineContextProvider: CoroutineContextProvider
    ) = SearchTeamsUseCase(
        teamsRepository = teamsRepository,
        coroutineContextProvider = coroutineContextProvider
    )

    @Provides
    fun providesTeamDomainToPresentationMapper() = TeamDomainToPresentationMapper()
}