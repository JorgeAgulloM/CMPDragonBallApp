package com.example.dragonballapp.ui.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import org.koin.androidx.compose.koinViewModel

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    val viewModel: HomeViewModel = koinViewModel()
    val example by viewModel.example.collectAsStateWithLifecycle()

    Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text(text = example)
    }
}
