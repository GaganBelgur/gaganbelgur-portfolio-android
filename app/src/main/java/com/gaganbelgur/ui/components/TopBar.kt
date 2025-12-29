package com.gaganbelgur.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import com.gaganbelgur.ui.theme.ThemeBlue

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun getTopBar(titleText: String) {
    TopAppBar(
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = ThemeBlue,
            titleContentColor = Color.White,
            navigationIconContentColor = MaterialTheme.colorScheme.primary,
            actionIconContentColor = MaterialTheme.colorScheme.primary
        ),
        title = {
            Text(
                titleText,
                modifier = Modifier
                    .fillMaxWidth(),
                textAlign = TextAlign.Center
            )
        }
    )
}