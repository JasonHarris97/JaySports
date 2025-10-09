package com.jasonharris97.jaysports.ui.core.view

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.jasonharris97.jaysports.presentation.core.model.PresentationDestination
import com.jasonharris97.jaysports.presentation.core.viewmodel.BaseViewModel
import com.jasonharris97.jaysports.ui.core.mapper.NotificationPresentationToUiMapper
import com.jasonharris97.jaysports.ui.navigation.mapper.DestinationPresentationToUiMapper
import kotlinx.coroutines.launch

abstract class BaseFragment<VIEW_STATE : Any, NOTIFICATION : Any> : Fragment() {
    protected abstract val viewModel: BaseViewModel<VIEW_STATE, NOTIFICATION>
    abstract val destinationMapper: DestinationPresentationToUiMapper
    abstract val notificationMapper: NotificationPresentationToUiMapper<NOTIFICATION>

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeViewModel()
    }

    private fun observeViewModel() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.notification.collect { notification ->
                    showNotification(notification)
                }
            }
        }
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.destination.collect { destination ->
                    navigateToDestination(destination)
                }
            }
        }
    }

    private fun showNotification(notification: NOTIFICATION) {
        notificationMapper.toUi(notification).show()
    }

    private fun navigateToDestination(destination: PresentationDestination) {
        destinationMapper.toUi(destination).navigate()
    }
}
