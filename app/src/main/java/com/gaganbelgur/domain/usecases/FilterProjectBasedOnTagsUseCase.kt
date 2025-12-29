package com.gaganbelgur.domain.usecases

import androidx.paging.PagingData
import com.gaganbelgur.domain.model.CompanyTags
import com.gaganbelgur.domain.repository.ProjectRepository
import com.gaganbelgur.model.Project
import com.gaganbelgur.utils.paging.PagingHelper
import jakarta.inject.Inject
import kotlinx.coroutines.flow.Flow

class FilterProjectBasedOnTagsUseCase @Inject constructor(
    private val projectRepository: ProjectRepository,
    private val pagingHelper: PagingHelper,
) {

    operator fun invoke(selectedCompanyTags: List<CompanyTags>): Flow<PagingData<Project>> {
        return pagingHelper.createPagingFlow { _, _ ->
            val allProjects = projectRepository.getAllProjects()

            if (selectedCompanyTags.isEmpty()) {
                allProjects
            } else {
                allProjects.filter { project ->
                    project.company in selectedCompanyTags
                }
            }
        }
    }
}