package com.gaganbelgur

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gaganbelgur.ui.navigation.PortfolioGraph
import com.gaganbelgur.ui.theme.DarkColorScheme
import com.gaganbelgur.ui.theme.GaganBelgurPortfolioAppTheme
import com.gaganbelgur.ui.theme.LightColorScheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val isDarkThemeEnabled = false

            val systemBarColor = if (isDarkThemeEnabled) Color.Black else Color.White
            val colorScheme = if (isDarkThemeEnabled) DarkColorScheme else LightColorScheme

            // Apply system bar styles based on your theme
            SideEffect {
                enableEdgeToEdge(
                    statusBarStyle = if (isDarkThemeEnabled) {
                        SystemBarStyle.dark(systemBarColor.toArgb())
                    } else {
                        SystemBarStyle.light(systemBarColor.toArgb(), systemBarColor.toArgb())
                    },
                    navigationBarStyle = if (isDarkThemeEnabled) {
                        SystemBarStyle.dark(systemBarColor.toArgb())
                    } else {
                        SystemBarStyle.light(systemBarColor.toArgb(), systemBarColor.toArgb())
                    }
                )
            }

            Surface(
                modifier = Modifier.fillMaxSize(),
                color = colorScheme.background
            ) {
                GaganBelgurPortfolioAppTheme(darkTheme = isDarkThemeEnabled) {
                    PortfolioGraph()
                }
            }
        }
    }
}

@Composable
fun PortfolioApp() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Gagan Belgur", style = MaterialTheme.typography.headlineLarge)
        Text(text = "Android Developer", style = MaterialTheme.typography.bodyLarge)
        Spacer(modifier = Modifier.height(16.dp))
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    GaganBelgurPortfolioAppTheme {
        PortfolioApp()
    }
}