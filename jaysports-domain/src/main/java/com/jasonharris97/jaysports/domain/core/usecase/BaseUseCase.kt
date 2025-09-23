package com.jasonharris97.jaysports.domain.core.usecase

interface BaseUseCase<REQUEST, RESULT> {
    suspend fun execute(input: REQUEST, onResult: (RESULT) -> Unit)
}