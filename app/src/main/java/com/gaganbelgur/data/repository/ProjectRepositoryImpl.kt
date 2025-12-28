package com.gaganbelgur.data.repository

import com.gaganbelgur.data.local.getProjectList
import com.gaganbelgur.domain.repository.ProjectRepository

class ProjectRepositoryImpl: ProjectRepository {

    override suspend fun getAllProjects() = getProjectList()
}