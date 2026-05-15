package com.mindmatrix.nammaplatform.presentation.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.graphics.Color

val RailwayBlue = Color(0xFF1565C0)
val PlatformYellow = Color(0xFFF9A825)
val CoachPink = Color(0xFFE91E63)
val SleeperBlue = Color(0xFF1E88E5)
val AcPurple = Color(0xFF7E57C2)

private val LightScheme: ColorScheme = lightColorScheme(
    primary = RailwayBlue,
    secondary = PlatformYellow,
    tertiary = CoachPink,
    background = Color(0xFFF7FAFF),
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color(0xFF1D1A00)
)

private val DarkScheme: ColorScheme = darkColorScheme(
    primary = Color(0xFF8EC5FF),
    secondary = PlatformYellow,
    tertiary = Color(0xFFFF8AB7),
    background = Color(0xFF07111F),
    surface = Color(0xFF101B2B),
    onPrimary = Color(0xFF002E5F)
)

@Composable
fun NammaPlatformTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val context = LocalContext.current
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }
        darkTheme -> DarkScheme
        else -> LightScheme
    }
    MaterialTheme(
        colorScheme = colorScheme,
        typography = NammaTypography,
        content = content
    )
}
