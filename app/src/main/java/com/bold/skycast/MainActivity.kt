package com.bold.skycast

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.lifecycleScope
import com.bold.skycast.ui.theme.SkyCastTheme
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupSplashScreen()
        enableEdgeToEdge()
        setContent {
            SkyCastTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    innerPadding
                }
            }
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