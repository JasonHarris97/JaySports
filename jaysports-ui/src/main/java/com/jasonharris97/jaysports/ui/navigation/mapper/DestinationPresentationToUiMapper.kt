package com.jasonharris97.jaysports.ui.navigation.mapper

import com.jasonharris97.jaysports.presentation.core.model.PresentationDestination
import com.jasonharris97.jaysports.ui.navigation.model.UiDestination

interface DestinationPresentationToUiMapper {
    fun toUi(input: PresentationDestination): UiDestination
}