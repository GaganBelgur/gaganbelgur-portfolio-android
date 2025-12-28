package com.gaganbelgur.domain.repository

import androidx.paging.PagingData
import com.gaganbelgur.domain.model.CompanyTags
import com.gaganbelgur.domain.model.Tag
import com.gaganbelgur.model.Project
import kotlinx.coroutines.flow.Flow

interface ProjectRepository {

    fun getAllProjects():  Flow<PagingData<Project>>

    fun getAllTags():  List<CompanyTags>
}