package com.gaganbelgur.domain.repository

import com.gaganbelgur.domain.model.CompanyTags
import com.gaganbelgur.model.Project

interface ProjectRepository {

    suspend fun getAllProjects(): List<Project>

    suspend fun getAllTags(): List<CompanyTags>
}