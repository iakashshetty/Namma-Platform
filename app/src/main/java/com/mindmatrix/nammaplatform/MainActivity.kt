package com.mindmatrix.nammaplatform

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.mindmatrix.nammaplatform.presentation.navigation.NammaPlatformNavHost
import com.mindmatrix.nammaplatform.presentation.theme.NammaPlatformTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NammaPlatformTheme {
                NammaPlatformNavHost()
            }
        }
    }
}
