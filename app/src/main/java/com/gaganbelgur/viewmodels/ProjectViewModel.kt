package com.gaganbelgur.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gaganbelgur.domain.usecases.ProjectUseCase
import com.gaganbelgur.model.Project
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProjectViewModel @Inject constructor(
    private val projectUseCase: ProjectUseCase
) : ViewModel(){

    private val _projectList = MutableStateFlow(emptyList<Project>())

    val projectList: StateFlow<List<Project>> = _projectList

    init {
        loadProjects()
    }

    private fun loadProjects() {
        viewModelScope.launch {
            _projectList.value = projectUseCase.getAllProjectUseCase()
        }
    }

}




