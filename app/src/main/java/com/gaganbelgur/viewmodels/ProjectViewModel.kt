package com.gaganbelgur.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.gaganbelgur.domain.model.CompanyTags
import com.gaganbelgur.domain.usecases.ProjectUseCase
import com.gaganbelgur.model.Project
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProjectViewModel @Inject constructor(
    private val projectUseCase: ProjectUseCase,
) : ViewModel() {

    private val _selectedCompanyTags = MutableStateFlow<List<CompanyTags>>(emptyList())

    val selectedCompanyTags: StateFlow<List<CompanyTags>> = _selectedCompanyTags

    private val _projects = MutableStateFlow<PagingData<Project>>(PagingData.empty())

    val projects: StateFlow<PagingData<Project>> = _projects

    private val _companyTags = MutableStateFlow<List<CompanyTags>>(emptyList())

    val companyTags: StateFlow<List<CompanyTags>> = _companyTags

    init {
        getAllProjects()
        getProjectTags()
    }

    private fun getAllProjects() {
        viewModelScope.launch {
            projectUseCase.getAllProjectUseCase()
                .cachedIn(viewModelScope)
                .collectLatest {
                _projects.value = it
            }
        }
    }

    private fun getProjectTags() {
        viewModelScope.launch {
            projectUseCase.getProjectTagsUseCase().collectLatest {
                _companyTags.value = it
            }
        }
    }

    fun updateSelectedTags(selectedCompanyTag: CompanyTags) {
        _selectedCompanyTags.update { current ->
            if (selectedCompanyTag in current) {
                current.minus(selectedCompanyTag)
            } else {
                current.plus(selectedCompanyTag)
            }
        }

        filterProjects()
    }

    private fun filterProjects() {
        viewModelScope.launch {
            projectUseCase.filterProjectBasedOnTagsUseCase.invoke(selectedCompanyTags.value)
                .collectLatest {
                    _projects.value = it
                }
        }
    }
}




