package com.example.dragonballapp

import android.app.Activity
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat
import com.example.dragonballapp.core.navigation.NavigationWrapper
import com.example.dragonballapp.resources.BackGroundPrimary
import org.jetbrains.compose.ui.tooling.preview.Preview

@RequiresApi(Build.VERSION_CODES.R)
@Composable
@Preview
fun App() {
    MaterialTheme {
        NavigationWrapper()
    }

    val statusBarLight = BackGroundPrimary.toArgb()
    val statusBarDark = BackGroundPrimary.toArgb()
    val navigationBarLight = BackGroundPrimary.toArgb()
    val navigationBarDark = BackGroundPrimary.toArgb()
    val view = LocalView.current
    val isDarkMod = isSystemInDarkTheme()

    DisposableEffect(isDarkMod) {
        val activity = view.context as Activity
        activity.window.statusBarColor = if (isDarkMod) {
            statusBarDark
        } else {
            statusBarLight
        }
        activity.window.navigationBarColor = if (isDarkMod) {
            navigationBarDark
        } else {
            navigationBarLight
        }

        WindowCompat.getInsetsController(activity.window, activity.window.decorView).apply {
            isAppearanceLightStatusBars = !isDarkMod
            isAppearanceLightNavigationBars = !isDarkMod
        }

        onDispose { }
    }
}
