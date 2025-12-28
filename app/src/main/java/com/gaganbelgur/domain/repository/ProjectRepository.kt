package com.gaganbelgur.domain.repository

import androidx.paging.PagingData
import com.gaganbelgur.model.Project
import kotlinx.coroutines.flow.Flow

interface ProjectRepository {

    fun getAllProjects():  Flow<PagingData<Project>>
}