package com.gaganbelgur.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext


// Light Theme Color Scheme (White background, black text/icons)
val LightColorScheme = lightColorScheme(
    primary = Color.Black,
    onPrimary = Color.White,

    background = Color.White,
    onBackground = Color.Black,

    surface = Color.White,
    onSurface = Color.Black,

    secondary = Color.Gray,
    onSecondary = Color.White,
    inverseOnSurface = Color.White,
    inverseSurface = Color.Black,

    // Optional
    primaryContainer = Color.LightGray,
    onPrimaryContainer = Color.Black,

    outline = Color.Gray,
)

// Dark Theme Color Scheme (Black background, white text/icons)
val DarkColorScheme = darkColorScheme(
    primary = Color.White,
    onPrimary = Color.Black,

    background = Color.Black,
    onBackground = Color.White,

    surface = Color.Black,
    onSurface = Color.White,

    secondary = Color.LightGray,
    onSecondary = Color.Black,
    inverseOnSurface = Color.Black,
    inverseSurface = Color.White,

    // Optional
    primaryContainer = Color.DarkGray,
    onPrimaryContainer = Color.White,

    outline = Color.DarkGray,
)

@Composable
fun GaganBelgurPortfolioAppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}