package com.jasonharris97.jaysports.ui.core.view

interface ViewStateBinder<in VIEW_STATE : Any> {
    fun bindState(viewState: VIEW_STATE)
}