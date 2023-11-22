package com.products.presentation.base

import androidx.lifecycle.ViewModel

abstract class BaseViewModel <US : UiState, UI : UiIntent, USE : UiSideEffect > : ViewModel(){

    abstract fun onEvent(uiIntent: UI)
}