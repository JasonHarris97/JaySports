package com.jasonharris97.jaysports.ui.searchTeams.view.compose

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.jasonharris97.jaysports.presentation.searchTeams.model.TeamPresentationModel
import com.jasonharris97.jaysports.presentation.searchTeams.viewmodel.SearchTeamsViewModel
import com.jasonharris97.jaysports.ui.R
import com.jasonharris97.jaysports.ui.searchTeams.model.TeamUiModel

@Composable
fun SearchTeamsScreen(
    viewModel: SearchTeamsViewModel,
    mapTeamToUiModel: (TeamPresentationModel) -> TeamUiModel
) {
    val viewState = viewModel.viewState.collectAsStateWithLifecycle().value

    SearchTeamsScreen(
        teams = viewState.teams.map { mapTeamToUiModel(it) },
        searchQuery = viewState.searchQuery,
        onSearchQueryChanged = viewModel::onSearchQueryChanged,
        onTeamClick = viewModel::onTeamSelected
    )
}

@Composable
private fun SearchTeamsScreen(
    teams: List<TeamUiModel>,
    searchQuery: String,
    onTeamClick: (String) -> Unit,
    onSearchQueryChanged: (String) -> Unit,
) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        TextField(
            value = searchQuery,
            onValueChange = onSearchQueryChanged,
            placeholder = {
                Text(stringResource(R.string.search_teams_placeholder ))
            }
        )
        teams.forEach { team ->
            Text(
                modifier = Modifier.clickable(
                    onClick = { onTeamClick(team.id) }
                ),
                text = team.name
            )
        }
    }
}