package com.gaganbelgur.ui.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.gaganbelgur.ui.screens.ProjectScreen
import com.gaganbelgur.viewmodels.ProjectViewModel

@Composable
fun PortfolioGraph() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.Project.route,
        modifier = Modifier.fillMaxSize()
    ) {
        composable(route = Screen.Project.route) {
            val viewModel = hiltViewModel<ProjectViewModel>()
            ProjectScreen(viewModel)
        }
    }
}