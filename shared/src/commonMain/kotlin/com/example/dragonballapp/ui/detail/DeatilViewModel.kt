package com.example.dragonballapp.ui.detail

import com.example.dragonballapp.domain.Repository
import com.example.dragonballapp.domain.model.CharacterDetailModel
import com.rickclephas.kmp.nativecoroutines.NativeCoroutinesState
import com.rickclephas.kmp.observableviewmodel.MutableStateFlow
import com.rickclephas.kmp.observableviewmodel.ViewModel
import com.rickclephas.kmp.observableviewmodel.launch
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.withContext

class DetailViewModel(private val id: Int, private val repository: Repository) : ViewModel() {
    private val _character = MutableStateFlow<CharacterDetailModel?>(viewModelScope, null)

    @NativeCoroutinesState
    val character: StateFlow<CharacterDetailModel?> = _character

    init {
        viewModelScope.launch {
            val response = withContext(Dispatchers.IO) {
                repository.getDetailCharacter(id)
            }
            response?.let { _character.update { it } }
        }
    }

}