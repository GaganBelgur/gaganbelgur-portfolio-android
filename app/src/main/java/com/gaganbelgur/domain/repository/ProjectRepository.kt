package com.gaganbelgur.domain.repository

import com.gaganbelgur.model.Project
import kotlinx.coroutines.flow.Flow

interface ProjectRepository {

    suspend fun getAllProjects(): List<Project>
}