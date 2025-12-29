package com.gaganbelgur.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.gaganbelgur.model.Project
import com.gaganbelgur.ui.components.PaginatedListScaffold
import com.gaganbelgur.ui.components.TagsFilterChipGroup
import com.gaganbelgur.viewmodels.ProjectViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProjectScreen(projectViewModel: ProjectViewModel) {
    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.onPrimary,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                    navigationIconContentColor = MaterialTheme.colorScheme.primary,
                    actionIconContentColor = MaterialTheme.colorScheme.primary
                ),
                title = { Text("Projects") }
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            val itemsFlow = projectViewModel.projects

            Spacer(modifier = Modifier.height(4.dp))

            val tags = projectViewModel.companyTags.collectAsState().value
            val selectedCompanyTags = projectViewModel.selectedCompanyTags.collectAsState().value

            TagsFilterChipGroup(
                tags = tags,
                selectedTag = selectedCompanyTags,
                onTagToggle = { projectViewModel.updateSelectedTags(it) }
            )

            Spacer(modifier = Modifier.height(8.dp))

            PaginatedListScaffold(
                itemsFlow = itemsFlow,
                modifier = Modifier
                    .fillMaxSize(),
                isSwipeRefreshEnabled = false,
                itemContent = { project ->
                    ProjectCard(project = project)
                }
            )
        }
    }
}

@Composable
fun ProjectCard(project: Project) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp, vertical = 4.dp),
        shape = RoundedCornerShape(4.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = project.name, style = MaterialTheme.typography.headlineSmall)

            Spacer(modifier = Modifier.height(8.dp))

            Text(text = project.description, style = MaterialTheme.typography.bodyMedium)

            Spacer(modifier = Modifier.height(8.dp))

            Row(modifier = Modifier.fillMaxWidth()) {
                LazyRow {
                    items(project.tags) { tags ->
                        FilterChip(
                            selected = true,
                            onClick = { },
                            label = { Text(tags.displayName) },
                            modifier = Modifier.padding(4.dp),
                            colors = FilterChipDefaults.filterChipColors(
                                selectedContainerColor = Color(0xFF1E88E5),
                                selectedLabelColor = Color.White,
                            )
                        )
                    }
                }

                project.company?.let { companyTags ->
                    FilterChip(
                        selected = true,
                        onClick = { },
                        label = { Text(text = companyTags.displayName) },
                        modifier = Modifier.padding(4.dp),
                        leadingIcon = {
                        },
                        colors = FilterChipDefaults.filterChipColors(
                            selectedContainerColor = Color(0xFFFB8C00),
                            selectedLabelColor = Color.White,
                        )
                    )
                }
            }
        }
    }
}