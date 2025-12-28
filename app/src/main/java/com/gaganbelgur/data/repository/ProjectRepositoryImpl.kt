package com.gaganbelgur.data.repository

import androidx.paging.PagingData
import com.gaganbelgur.data.local.getProjectList
import com.gaganbelgur.domain.repository.ProjectRepository
import com.gaganbelgur.model.Project
import com.gaganbelgur.utils.paging.PagingHelper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ProjectRepositoryImpl @Inject constructor(private val pagingHelper: PagingHelper): ProjectRepository {

    override fun getAllProjects(): Flow<PagingData<Project>> = pagingHelper.createPagingFlow { _, _ ->
        withContext(Dispatchers.IO) {
            getProjectList()
        }
    }
}