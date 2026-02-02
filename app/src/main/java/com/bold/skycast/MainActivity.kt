package com.bold.skycast

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.lifecycleScope
import com.bold.skycast.presentation.SkyCastScreen
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupSplashScreen()
        enableEdgeToEdge()
        setContent {
            SkyCastScreen()
        }
    }
}

private fun ComponentActivity.setupSplashScreen() {
    val splashscreen = installSplashScreen()
    var keepSplashScreen = true
    splashscreen.setKeepOnScreenCondition { keepSplashScreen }
    lifecycleScope.launch {
        delay(3000)
        keepSplashScreen = false
    }
}