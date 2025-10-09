package com.jasonharris97.jaysports.ui.searchTeams.mapper

import com.jasonharris97.jaysports.ui.navigation.mapper.DestinationPresentationToUiMapper
import com.jasonharris97.jaysports.ui.navigation.model.UiDestination

interface SearchTeamsDestinationToUiMapper : DestinationPresentationToUiMapper {
    abstract class SearchTeamsUiDestination(
        open val teamId: String
    ) : UiDestination
}