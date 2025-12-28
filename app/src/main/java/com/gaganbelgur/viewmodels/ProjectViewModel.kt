package com.gaganbelgur.viewmodels

import androidx.lifecycle.ViewModel
import com.gaganbelgur.domain.usecases.ProjectUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProjectViewModel @Inject constructor(
    private val projectUseCase: ProjectUseCase
) : ViewModel(){

    fun getAllProjects() = projectUseCase.getAllProjectUseCase()

    fun getProjectTags() = projectUseCase.getProjectTagsUseCase()
}




