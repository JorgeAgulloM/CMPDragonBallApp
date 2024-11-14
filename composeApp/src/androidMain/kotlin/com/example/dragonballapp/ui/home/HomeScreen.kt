package com.example.dragonballapp.ui.home

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.compose.AsyncImage
import com.example.dragonballapp.R
import com.example.dragonballapp.domain.model.CharacterModel
import com.example.dragonballapp.resources.BackGroundPrimary
import com.example.dragonballapp.resources.Orange
import com.example.dragonballapp.resources.White
import org.koin.androidx.compose.koinViewModel

@Composable
fun HomeScreen(modifier: Modifier = Modifier, navigateToDetail: (Int) -> Unit) {
    val viewModel: HomeViewModel = koinViewModel()
    val characters by viewModel.characters.collectAsStateWithLifecycle()

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(BackGroundPrimary),//.copy(alpha = 0.8f)),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Goku Edition",
            modifier.padding(4.dp),
            fontWeight = FontWeight.Bold,
            fontSize = 26.sp,
            color = White
        )
        LazyColumn(contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)) {
            items(characters) { character ->
                CharacterItem(character = character) { id -> navigateToDetail(id) }
            }
        }
    }
}

@Composable
fun CharacterItem(character: CharacterModel, onItemClicked: (Int) -> Unit) {
    Box(
        modifier = Modifier
            .padding(16.dp)
            .height(250.dp)
            .clickable { onItemClicked(character.id) },
        contentAlignment = Alignment.TopCenter
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Spacer(modifier = Modifier.weight(1f))
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(20),
                border = BorderStroke(2.dp, Orange),
                colors = CardDefaults.cardColors(White),
                elevation = CardDefaults.cardElevation(4.dp)
            ) {
                Column(
                    modifier = Modifier.padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(text = character.name, fontWeight = FontWeight.Bold, fontSize = 22.sp)
                    Text(text = character.race, fontSize = 20.sp, fontStyle = FontStyle.Italic)
                }
            }
        }
        DragonBallShape()
        AsyncImage(
            model = character.image,
            contentDescription = "Image of ${character.name}",
            modifier = Modifier
                .size(190.dp)
                .padding(top = 16.dp)
                .offset((3).dp, (2).dp),
            colorFilter = ColorFilter.tint(Color.Black.copy(alpha = 0.6f))
        )
        AsyncImage(
            model = character.image,
            contentDescription = "Image of ${character.name}",
            modifier = Modifier
                .size(190.dp)
                .padding(top = 16.dp)
        )
    }
}

@Preview
@Composable
fun DragonBallShape(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .size(180.dp)
            .clip(CircleShape)
            .background(
                Brush.linearGradient(
                    listOf(
                        Orange,
                        Color.White.copy(alpha = 0.9f),
                        Orange.copy(alpha = 0.95f),
                        Orange.copy(alpha = 0.9f),
                        Orange,
                        Orange,
                        Orange
                    )
                )
            )
            .border(
                BorderStroke(
                    3.dp,
                    Brush.linearGradient(
                        listOf(
                            Orange.copy(alpha = 0.8f),
                            Color.White.copy(alpha = 0.8f),
                            Color.White.copy(alpha = 0.7f),
                            Orange,
                            Orange,
                            Orange,
                            Orange
                        )
                    )
                ),
                CircleShape
            )
            .rotate(80f),
        contentAlignment = Alignment.Center
    ) {
        Row {
            Column {
                DragonBalStart()
                DragonBalStart()
            }
            Column {
                DragonBalStart()
                DragonBalStart()
            }
        }
    }
}

@Composable
fun DragonBalStart() {
    Icon(
        modifier = Modifier
            .padding(16.dp)
            .size(24.dp)
            .rotate(-60f),
        painter = painterResource(id = R.drawable.ic_start),
        contentDescription = null,
        tint = Color.Red
    )
}