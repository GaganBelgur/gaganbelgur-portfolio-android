package com.gaganbelgur.ui.components

import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.gaganbelgur.domain.model.CompanyTags

@Composable
fun TagsFilterChipGroup(
    tags: List<CompanyTags>,
    selectedTag: List<CompanyTags>,
    onTagToggle: (CompanyTags) -> Unit,
    modifier: Modifier = Modifier,
) {
    FlowRow(
        modifier = modifier.padding(0.dp),
        maxLines = 1
    ) {
        LazyRow {
            items(items = tags) { tag ->
                FilterChip(
                    selected = selectedTag.contains(tag),
                    onClick = { onTagToggle(tag) },
                    label = { Text(tag.displayName) },
                    modifier = Modifier.padding(4.dp),

                    colors = FilterChipDefaults.filterChipColors(
                        containerColor = Color.White,
                        labelColor = Color(0xFF1E88E5),
                        selectedContainerColor = Color(0xFF1E88E5),
                        selectedLabelColor = Color.White
                    )
                )
            }
        }
    }
}
