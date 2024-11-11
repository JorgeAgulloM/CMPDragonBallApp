package com.example.dragonballapp

import android.app.Application
import com.example.dragonballapp.di.initKoin
import com.example.dragonballapp.di.uiModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger

class DragonBallApp : Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin(
            extraModules = listOf(uiModule),
            config = {
                androidLogger()
                androidContext(this@DragonBallApp)
            }
        )
    }
}
