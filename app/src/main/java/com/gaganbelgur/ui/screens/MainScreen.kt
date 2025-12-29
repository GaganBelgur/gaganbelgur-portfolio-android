package com.gaganbelgur.ui.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.gaganbelgur.ui.navigation.TabItems
import com.gaganbelgur.ui.navigation.PortfolioGraph
import com.gaganbelgur.ui.theme.ThemeBlue
import com.gaganbelgur.ui.theme.ThemeOrange

@Composable
fun MainScreen() {
    val navController = rememberNavController()

    val items = TabItems.ALL

    Scaffold(
        bottomBar = {
            NavigationBar(containerColor = ThemeBlue, contentColor = Color.White) {
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentDestination = navBackStackEntry?.destination

                items.forEach { screen ->
                    NavigationBarItem(
                        icon = { Icon(screen.icon, contentDescription = screen.label) },
                        label = { Text(screen.label) },
                        selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true,
                        onClick = {
                            navController.navigate(screen.route) {
                                // Pop up to the start destination of the graph to
                                // avoid building up a large stack of destinations
                                // on the back stack as users select items
                                popUpTo(navController.graph.findStartDestination().id) {
                                    saveState = true
                                }
                                // Avoid multiple copies of the same destination when
                                // re-selecting the same item
                                launchSingleTop = true
                                // Restore state when re-selecting a previously selected item
                                restoreState = true
                            }
                        },
                        colors = NavigationBarItemDefaults.colors(
                            selectedIconColor =  ThemeOrange,
                            selectedTextColor =  ThemeOrange,
                            unselectedIconColor = Color.White,
                            unselectedTextColor = Color.White,
                            indicatorColor = Color.Transparent
                        )
                    )
                }
            }
        }
    ) { innerPadding ->
        // Pass the NavController to your navigation graph
        PortfolioGraph(
            navController = navController,
            modifier = Modifier.padding(innerPadding)
        )
    }
}
