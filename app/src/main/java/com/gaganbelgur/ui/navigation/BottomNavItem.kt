package com.gaganbelgur.ui.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Work
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomNavItem(val route: String, val icon: ImageVector, val label: String) {
    object Projects : BottomNavItem("project", Icons.Default.Work, "Projects")
    object About : BottomNavItem("about", Icons.Default.Info, "About")
}
