package com.gaganbelgur.domain.usecases

import com.gaganbelgur.domain.model.CompanyTags
import com.gaganbelgur.domain.repository.ProjectRepository
import jakarta.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetProjectTagsUseCase @Inject constructor(private val projectRepository: ProjectRepository) {

    operator fun invoke(): Flow<List<CompanyTags>> {
        return flow {
            var tagsList = projectRepository.getAllTags()

            if (tagsList.isEmpty()) {
                emit(emptyList())
            }

            tagsList = tagsList.toMutableList()
            tagsList.add(CompanyTags.ALL)
            emit(tagsList.toList())
        }
    }
}