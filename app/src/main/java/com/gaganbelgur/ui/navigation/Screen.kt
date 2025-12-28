package com.gaganbelgur.ui.navigation

sealed class Screen(val route: String, val title: String) {

    object Project : Screen("project", "Project")


}