package com.gaganbelgur.domain.usecases

import androidx.paging.PagingData
import com.gaganbelgur.domain.repository.ProjectRepository
import com.gaganbelgur.model.Project
import com.gaganbelgur.utils.paging.PagingHelper
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAllProjectUseCase @Inject constructor(
    private val projectRepository: ProjectRepository,
    private val pagingHelper: PagingHelper,
) {
    operator fun invoke(): Flow<PagingData<Project>> {
        return pagingHelper.createPagingFlow { _, _ ->
            projectRepository.getAllProjects()
        }
    }
}