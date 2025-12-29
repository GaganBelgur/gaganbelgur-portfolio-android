package com.gaganbelgur.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SecondaryScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import com.gaganbelgur.ui.components.getTopBar
import com.gaganbelgur.ui.navigation.TabItems
import com.gaganbelgur.ui.theme.ThemeBlue
import com.gaganbelgur.ui.theme.ThemeOrange
import com.gaganbelgur.viewmodels.ProjectViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScrollableTabScreen() {
    var selectedTabIndex by remember { mutableStateOf(0) }

    val tabs = remember {
        TabItems.ALL
    }

    Scaffold(
        topBar = {
            getTopBar("Gagan Belgur Portfolio")
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            SecondaryScrollableTabRow(
                selectedTabIndex = selectedTabIndex,
                modifier = Modifier.fillMaxWidth(),
                containerColor = ThemeBlue,
                contentColor = Color.White,
                edgePadding = 0.dp,
                indicator = {
                    TabRowDefaults.SecondaryIndicator(
                        modifier = Modifier.tabIndicatorOffset(selectedTabIndex),
                        color = ThemeOrange
                    )
                }
            ) {
                tabs.forEachIndexed { index, tabItem ->
                    Tab(
                        selected = index == selectedTabIndex,
                        onClick = { selectedTabIndex = index },
                        text = {
                            Text(
                                text = tabItem.label,
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis,
                                fontWeight = FontWeight.Bold,
                            )
                        },
                        selectedContentColor = ThemeOrange,
                        unselectedContentColor = Color.White
                    )
                }
            }
            TabContent(selectedTab = tabs[selectedTabIndex])
        }
    }
}

/**
 * A simple composable to display the content for the selected tab.
 */
@Composable
fun TabContent(selectedTab: TabItems) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        when (selectedTab) {
            TabItems.About -> {
                AboutScreen()
            }
            TabItems.Projects -> {
                val viewModel = hiltViewModel<ProjectViewModel>()
                ProjectScreen(viewModel)
            }
            TabItems.Experience -> {
                // Content for Experience tab
            }
            TabItems.Responsibility -> {
                // Content for Responsibility tab
            }
            TabItems.TechnicalSkills -> {
                // Content for Technical Skills tab
            }
            TabItems.Achievements -> {
                // Content for Achievements tab
            }
            TabItems.Strengths -> {
                // Content for Strengths tab
            }
            TabItems.Stats -> {
                // Content for Stats tab
            }
            TabItems.EducationAndCertification -> {
                // Content for Education & Certification tab
            }
            TabItems.Languages -> {
                // Content for Languages tab
            }
            TabItems.SoftSkills -> {
                // Content for Soft Skills tab
            }
            TabItems.Connect -> {
                // Content for Connect tab
            }
        }
    }
}
