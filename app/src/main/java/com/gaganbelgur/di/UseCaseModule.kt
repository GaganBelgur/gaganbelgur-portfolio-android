package com.gaganbelgur.di

import com.gaganbelgur.domain.repository.ProjectRepository
import com.gaganbelgur.domain.usecases.FilterProjectBasedOnTagsUseCase
import com.gaganbelgur.domain.usecases.GetAllProjectUseCase
import com.gaganbelgur.domain.usecases.GetProjectTagsUseCase
import com.gaganbelgur.domain.usecases.ProjectUseCase
import com.gaganbelgur.utils.paging.PagingHelper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    fun provideProjectUseCases(
        repository: ProjectRepository,
        pageHelper: PagingHelper,
    ): ProjectUseCase {
        return ProjectUseCase(
            getAllProjectUseCase = GetAllProjectUseCase(repository, pageHelper),
            getProjectTagsUseCase = GetProjectTagsUseCase(repository),
            filterProjectBasedOnTagsUseCase = FilterProjectBasedOnTagsUseCase(
                repository,
                pageHelper
            )
        )
    }
}
