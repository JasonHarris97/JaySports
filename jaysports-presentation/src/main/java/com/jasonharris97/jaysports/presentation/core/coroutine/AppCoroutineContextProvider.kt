package com.jasonharris97.jaysports.presentation.core.coroutine

import com.jasonharris97.jaysports.domain.core.coroutine.CoroutineContextProvider
import kotlinx.coroutines.Dispatchers

class AppCoroutineContextProvider : CoroutineContextProvider {
    override val main = Dispatchers.Main
    override val io = Dispatchers.IO
}