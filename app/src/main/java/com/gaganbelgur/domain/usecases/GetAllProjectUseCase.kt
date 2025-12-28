package com.gaganbelgur.domain.usecases

import com.gaganbelgur.domain.repository.ProjectRepository
import com.gaganbelgur.model.Project
import jakarta.inject.Inject

class GetAllProjectUseCase @Inject constructor(private val projectRepository: ProjectRepository) {

    suspend operator fun invoke(): List<Project> {
        return projectRepository.getAllProjects()
    }
}