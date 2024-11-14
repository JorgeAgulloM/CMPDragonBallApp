package com.example.dragonballapp.ui.componentes

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

@Composable
fun CharacterImage(
    modifier: Modifier = Modifier.size(190.dp),
    characterImage: String,
    characterName: String,
    isShadow: Boolean = true
) {
    Box(contentAlignment = Alignment.Center) {
        if (isShadow) AsyncImage(
            model = characterImage,
            contentDescription = null,
            modifier = modifier
                .padding(top = 16.dp)
                .offset((6).dp, (4).dp),
            colorFilter = ColorFilter.tint(Color.Black.copy(alpha = 0.6f))
        )
        AsyncImage(
            model = characterImage,
            contentDescription = characterName,
            modifier = modifier
                .padding(top = 16.dp)
        )
    }
}
