package com.example.dragonballapp.ui.home

import com.example.dragonballapp.domain.Repository
import com.example.dragonballapp.domain.model.CharacterModel
import com.rickclephas.kmp.nativecoroutines.NativeCoroutinesState
import com.rickclephas.kmp.observableviewmodel.MutableStateFlow
import com.rickclephas.kmp.observableviewmodel.ViewModel
import com.rickclephas.kmp.observableviewmodel.launch
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.withContext

class HomeViewModel(private val repository: Repository): ViewModel() {
    private val _example = MutableStateFlow( viewModelScope,"Yorch")
    @NativeCoroutinesState
    val example: StateFlow<String> = _example

    private val _characters = MutableStateFlow<List<CharacterModel>>( viewModelScope, emptyList())
    @NativeCoroutinesState
    val characters: StateFlow<List<CharacterModel>> = _characters

    init {
        viewModelScope.launch {
            val response = withContext(Dispatchers.IO) {
                repository.getCharacters()
            }
            _characters.update { response }
        }
    }

}