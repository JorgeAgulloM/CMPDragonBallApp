package com.example.dragonballapp.ui.home

import com.rickclephas.kmp.nativecoroutines.NativeCoroutinesState
import com.rickclephas.kmp.observableviewmodel.MutableStateFlow
import com.rickclephas.kmp.observableviewmodel.ViewModel
import kotlinx.coroutines.flow.StateFlow

class HomeViewModel: ViewModel() {
    private val _example = MutableStateFlow( viewModelScope,"Yorch")
    @NativeCoroutinesState
    val example: StateFlow<String> = _example
}