package com.jasonharris97.jaysports.app.di.searchTeams

import com.jasonharris97.jaysports.ui.searchTeams.mapper.SearchTeamsNotificationPresentationToUiMapper
import com.jasonharris97.jaysports.ui.searchTeams.mapper.TeamPresentationToUiMapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent

@Module
@InstallIn(FragmentComponent::class)
class SearchTeamsUiModule {

    @Provides
    fun providesSearchTeamsNotificationPresentationToUiMapper() =
        SearchTeamsNotificationPresentationToUiMapper()


    @Provides
    fun providesTeamPresentationToUiMapper() = TeamPresentationToUiMapper()
}