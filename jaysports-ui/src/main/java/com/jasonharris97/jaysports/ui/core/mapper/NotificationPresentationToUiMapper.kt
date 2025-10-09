package com.jasonharris97.jaysports.ui.core.mapper

import com.jasonharris97.jaysports.ui.core.model.NotificationUiModel

interface NotificationPresentationToUiMapper<PRESENTATION_NOTIFICATION : Any> {
    fun toUi(presentationNotification: PRESENTATION_NOTIFICATION): NotificationUiModel
}