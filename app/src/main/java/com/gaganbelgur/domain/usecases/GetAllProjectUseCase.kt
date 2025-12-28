package com.gaganbelgur.domain.usecases

import androidx.paging.PagingData
import com.gaganbelgur.domain.repository.ProjectRepository
import com.gaganbelgur.model.Project
import jakarta.inject.Inject
import kotlinx.coroutines.flow.Flow

class GetAllProjectUseCase @Inject constructor(private val projectRepository: ProjectRepository) {

    operator fun invoke(): Flow<PagingData<Project>> {
        return projectRepository.getAllProjects()
    }
}