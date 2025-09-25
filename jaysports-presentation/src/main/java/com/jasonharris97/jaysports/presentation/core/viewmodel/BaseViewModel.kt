package com.jasonharris97.jaysports.presentation.core.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jasonharris97.jaysports.domain.core.exception.DomainException
import com.jasonharris97.jaysports.domain.core.usecase.UseCase
import com.jasonharris97.jaysports.domain.core.usecase.UseCaseExecutor
import com.jasonharris97.jaysports.presentation.core.model.PresentationDestination
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlin.getValue

abstract class BaseViewModel<VIEW_STATE : Any, NOTIFICATION : Any>(
    useCaseExecutorProvider: (coroutineScope: CoroutineScope) -> UseCaseExecutor
) : ViewModel() {
    private val _viewState : MutableStateFlow<VIEW_STATE> = MutableStateFlow(value = initialState())
    val viewState : StateFlow<VIEW_STATE> = _viewState
    private val _notification = MutableSharedFlow<NOTIFICATION>()
    val notification: SharedFlow<NOTIFICATION> = _notification
    private val _destination = MutableSharedFlow<PresentationDestination>()
    val destination: SharedFlow<PresentationDestination> = _destination

    protected abstract fun initialState(): VIEW_STATE

    private val currentViewState: VIEW_STATE
        get() = viewState.value

    private val useCaseExecutor by lazy {
        useCaseExecutorProvider(viewModelScope)
    }

    protected fun <OUTPUT> execute(
        useCase: UseCase<Unit, OUTPUT>,
        onSuccess: (OUTPUT) -> Unit = {},
        onException: (DomainException) -> Unit = {}
    ) {
        execute(useCase, Unit, onSuccess, onException)
    }

    protected fun <INPUT, OUTPUT> execute(
        useCase: UseCase<INPUT, OUTPUT>,
        value: INPUT,
        onSuccess: (OUTPUT) -> Unit = {},
        onException: (DomainException) -> Unit = {}
    ) {
        useCaseExecutor.execute(useCase, value, onSuccess, onException)
    }

    protected fun updateViewState(newViewState: VIEW_STATE) {
        _viewState.value = newViewState
    }

    protected fun updateViewState(
        updatedState: VIEW_STATE.() -> VIEW_STATE
    ) = updateViewState(currentViewState.updatedState())

    protected fun notify(notification: NOTIFICATION) {
        viewModelScope.launch {
            _notification.emit(notification)
        }
    }

    protected fun navigateTo(destination: PresentationDestination) {
        viewModelScope.launch {
            _destination.emit(destination)
        }
    }

    protected fun navigateBack() {
        viewModelScope.launch {
            _destination.emit(PresentationDestination.Back)
        }
    }
}
