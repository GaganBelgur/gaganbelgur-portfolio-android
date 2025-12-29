package com.gaganbelgur.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.gaganbelgur.ui.screens.AboutScreen
import com.gaganbelgur.ui.screens.ProjectScreen
import com.gaganbelgur.viewmodels.ProjectViewModel

@Composable
fun PortfolioGraph(
    navController: NavHostController,
    modifier: Modifier = Modifier,
) {

    NavHost(
        navController = navController,
        startDestination = TabItems.About.route,
        modifier = modifier
    ) {
        composable(route = Screen.About.route) {
            AboutScreen()
        }

        composable(route = Screen.Project.route) {
            val viewModel = hiltViewModel<ProjectViewModel>()
            ProjectScreen(viewModel)
        }
    }
}