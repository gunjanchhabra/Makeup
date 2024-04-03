package com.products.presentation.base

import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow

interface Mvi<UiIntent, UiState, UiSideEffect >{
    fun sendIntent(uiIntent: UiIntent)

    val uiState : StateFlow<UiState>

    val uiSideEffect : SharedFlow<UiSideEffect>
}