package com.gaganbelgur.data.repository

import com.gaganbelgur.data.local.getProjectList
import com.gaganbelgur.domain.model.CompanyTags
import com.gaganbelgur.domain.repository.ProjectRepository
import com.gaganbelgur.model.Project
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ProjectRepositoryImpl: ProjectRepository {

    override suspend fun getAllProjects(): List<Project> {
        return withContext(Dispatchers.IO) {
            getProjectList()
        }
    }

    override suspend fun getAllTags(): List<CompanyTags> {
        return withContext(Dispatchers.IO) {
            getProjectList().mapNotNull { it.company }
                .distinct()
                .sortedBy { it.displayName }
        }
    }
}