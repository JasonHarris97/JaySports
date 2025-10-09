package com.jasonharris97.jaysports.app.di.core

import com.jasonharris97.jaysports.domain.core.coroutine.CoroutineContextProvider
import com.jasonharris97.jaysports.presentation.core.coroutine.AppCoroutineContextProvider
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class CorePresentationModule {
    @Provides
    fun providesCoroutineContextProvider(): CoroutineContextProvider =
        AppCoroutineContextProvider()
}