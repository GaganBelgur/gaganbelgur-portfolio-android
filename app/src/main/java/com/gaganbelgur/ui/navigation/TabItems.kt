package com.gaganbelgur.ui.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Archive
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Rowing
import androidx.compose.material.icons.filled.Work
import androidx.compose.ui.graphics.vector.ImageVector

sealed class TabItems(val route: String, val icon: ImageVector, val label: String) {
    object Projects : TabItems("project", Icons.Default.Work, "Projects")

    object About : TabItems("about", Icons.Default.Info, "About")

    object Experience : TabItems("experience", Icons.Default.Archive, "Work Experience")

    object Responsibility : TabItems("responsibility", Icons.Default.Rowing, "Responsibility")

    object TechnicalSkills : TabItems("skills", Icons.Default.Rowing, "Technical Skills")

    object Achievements : TabItems("achievements", Icons.Default.Rowing, "Achievements")

    object Strengths : TabItems("strengths", Icons.Default.Rowing, "Personal Strengths")

    object Stats : TabItems("stats", Icons.Default.Rowing, "Stats")

    object EducationAndCertification : TabItems("education", Icons.Default.Rowing, "Education & Certification")

    object Languages : TabItems("languages", Icons.Default.Rowing, "Languages")

    object SoftSkills : TabItems("softskills", Icons.Default.Rowing, "Soft Skills")

    object Connect : TabItems("connect", Icons.Default.Rowing, "Connect")

    companion object {
        val ALL = listOf<TabItems>(
            About,
            Projects,
            Experience,
            Responsibility,
            TechnicalSkills,
            Achievements,
            Strengths,
            Stats,
            EducationAndCertification,
            Languages,
            SoftSkills,
            Connect
        )
    }
}
