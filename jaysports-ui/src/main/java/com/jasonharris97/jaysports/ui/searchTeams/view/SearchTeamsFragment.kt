package com.jasonharris97.jaysports.ui.searchTeams.view
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.fragment.app.viewModels
import com.jasonharris97.jaysports.presentation.searchTeams.model.SearchTeamsViewState
import com.jasonharris97.jaysports.presentation.searchTeams.viewmodel.SearchTeamsViewModel
import com.jasonharris97.jaysports.ui.core.view.BaseFragment
import com.jasonharris97.jaysports.ui.searchTeams.mapper.SearchTeamsDestinationToUiMapper
import com.jasonharris97.jaysports.ui.searchTeams.mapper.SearchTeamsNotificationPresentationToUiMapper
import com.jasonharris97.jaysports.ui.searchTeams.mapper.TeamPresentationToUiMapper
import com.jasonharris97.jaysports.ui.searchTeams.view.compose.SearchTeamsScreen
import com.jasonharris97.jaysports.ui.theme.JaySportsTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class SearchTeamsFragment : BaseFragment<SearchTeamsViewState, Unit>() {
    override val viewModel: SearchTeamsViewModel by viewModels()

    @Inject
    override lateinit var destinationMapper: SearchTeamsDestinationToUiMapper

    @Inject
    override lateinit var notificationMapper: SearchTeamsNotificationPresentationToUiMapper

    @Inject
    lateinit var teamPresentationToUiMapper: TeamPresentationToUiMapper

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return ComposeView(requireContext()).apply {
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            setContent {
                JaySportsTheme {
                    SearchTeamsScreen(
                        viewModel = viewModel,
                        mapTeamToUiModel = teamPresentationToUiMapper::toUi
                    )
                }
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (savedInstanceState == null) {
            viewModel.onEntered()
        }
    }
}
