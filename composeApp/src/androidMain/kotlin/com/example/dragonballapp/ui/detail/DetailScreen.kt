package com.example.dragonballapp.ui.detail

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.dragonballapp.R
import com.example.dragonballapp.domain.model.CharacterDetailModel
import com.example.dragonballapp.domain.model.TransformationModel
import com.example.dragonballapp.resources.Orange
import com.example.dragonballapp.resources.White
import com.example.dragonballapp.ui.componentes.CharacterImage
import org.koin.androidx.compose.koinViewModel
import org.koin.core.parameter.parametersOf

@Composable
fun DetailScreen(modifier: Modifier = Modifier, id: Int, navigateBack: () -> Unit) {
    val viewModel: DetailViewModel = koinViewModel(parameters = { parametersOf(id) })
    val detail by viewModel.character.collectAsStateWithLifecycle()

    Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        detail?.let { character ->
            ItemDetail(character, navigateBack)
        } ?: run { CircularProgressIndicator(color = Orange) }
    }
}

@Composable
fun ItemDetail(character: CharacterDetailModel, navigateBack: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    listOf(Color.Black, Orange),
                    startY = 0f,
                    endY = 450f
                )
            )
    ) {
        Box(contentAlignment = Alignment.TopCenter) {
            Card(
                modifier = Modifier
                    .padding(start = 16.dp, end = 16.dp, top = 150.dp, bottom = 48.dp)
                    .fillMaxSize()
            ) {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Spacer(modifier = Modifier.height(120.dp))
                    Text(
                        text = character.characterModel.name,
                        fontSize = 28.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = Color.Black
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Row(horizontalArrangement = Arrangement.Center) {
                        CharacterLabel(text = character.characterModel.race)
                        Spacer(modifier = Modifier.width(32.dp))
                        CharacterLabel(text = character.characterModel.gender)
                    }
                    Row(Modifier.height(75.dp)) {
                        IconInformation(
                            modifier = Modifier.weight(1f),
                            id = R.drawable.ic_ki,
                            data = character.characterModel.ki
                        )
                        VerticalDivider(thickness = 2.dp)
                        IconInformation(
                            modifier = Modifier.weight(1f),
                            id = R.drawable.ic_planet,
                            data = character.originPlanet.name
                        )
                    }
                    TransformationList(
                        modifier = Modifier.fillMaxSize(),
                        transformations = character.transformations
                    )
                }
            }
            CharacterImage(
                modifier = Modifier.size(250.dp),
                characterImage = character.characterModel.image,
                characterName = character.characterModel.name
            )
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Start
            ) {
                Icon(
                    painterResource(R.drawable.ic_back),
                    contentDescription = "Back",
                    tint = White,
                    modifier = Modifier
                        .padding(16.dp)
                        .size(24.dp)
                        .clip(CircleShape)
                        .clickable { navigateBack() }
                )
            }
        }
    }
}

@Composable
fun TransformationList(modifier: Modifier = Modifier, transformations: List<TransformationModel>) {
    Box(modifier = modifier, contentAlignment = Alignment.Center) {
        if (transformations.isEmpty()) {
            Text(text = "No hay transformaciones disponibles para este personaje")
        } else {
            val pagerState = rememberPagerState(pageCount = { transformations.size })
            HorizontalPager(
                state = pagerState,
                pageSize = PageSize.Fixed(pageSize = 150.dp),
                pageSpacing = 4.dp
            ) { pos ->
                TRansformationSticker(transformations = transformations[pos])
            }
        }
    }

}

@Composable
fun TRansformationSticker(transformations: TransformationModel) {
    Card(
        modifier = Modifier.padding(horizontal = 6.dp, vertical = 24.dp),
        onClick = {},
        border = BorderStroke(2.dp, Color.Gray.copy(alpha = 0.4f)),
        elevation = CardDefaults.cardElevation(defaultElevation = 12.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CharacterImage(
                modifier = Modifier.size(240.dp),
                characterImage = transformations.image,
                characterName = transformations.name,
                isShadow = false
            )
            Text(
                text = transformations.name,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )
        }
    }
}

@Composable
private fun CharacterLabel(text: String) {
    Text(
        text = text,
        modifier = Modifier
            .border(2.dp, color = Orange, shape = RoundedCornerShape(50))
            .padding(horizontal = 16.dp, vertical = 2.dp)
    )
}

@Composable
fun IconInformation(modifier: Modifier = Modifier, id: Int, data: String) {
    Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        Image(painterResource(id), contentDescription = null, modifier = Modifier.size(48.dp))
        Text(text = data)
    }

}
