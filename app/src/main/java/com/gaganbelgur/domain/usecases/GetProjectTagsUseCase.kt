package com.gaganbelgur.domain.usecases

import com.gaganbelgur.domain.model.CompanyTags
import com.gaganbelgur.domain.repository.ProjectRepository
import jakarta.inject.Inject

class GetProjectTagsUseCase @Inject constructor(private val projectRepository: ProjectRepository) {

    operator fun invoke(): List<CompanyTags> {
        var tagsList = projectRepository.getAllTags()

        if (tagsList.isEmpty()) {
            return emptyList()
        }

        tagsList = tagsList.toMutableList()
        tagsList.add(0,CompanyTags.ALL)

        return tagsList.toList()
    }
}