package com.example.dragonballapp.ui.detail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.dragonballapp.domain.model.CharacterDetailModel
import com.example.dragonballapp.resources.Orange
import com.example.dragonballapp.resources.White
import com.example.dragonballapp.ui.componentes.CharacterImage
import org.koin.androidx.compose.koinViewModel
import org.koin.core.parameter.parametersOf

@Composable
fun DetailScreen(modifier: Modifier = Modifier, id: Int) {
    val viewModel: DetailViewModel = koinViewModel(parameters = { parametersOf(id) })
    val detail by viewModel.character.collectAsStateWithLifecycle()

    Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        detail?.let { character ->
            ItemDetail(character)
        } ?: run { CircularProgressIndicator(color = Orange) }
    }
}

@Composable
fun ItemDetail(character: CharacterDetailModel) {
    Column(modifier = Modifier.fillMaxSize().background(Color.Black.copy(alpha = 0.6f))) {
        Box(modifier = Modifier
            .fillMaxWidth()
            .height(250.dp)
            .clip(RoundedCornerShape(bottomStartPercent = 15, bottomEndPercent = 15))
            .background(White),
            contentAlignment = Alignment.Center
        ) {
            CharacterImage(
                modifier = Modifier.size(300.dp),
                characterImage = character.characterModel.image,
                characterName = character.characterModel.name
            )
        }
    }
}
