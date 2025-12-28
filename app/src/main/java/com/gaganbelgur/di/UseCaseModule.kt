package com.gaganbelgur.di

import com.gaganbelgur.domain.repository.ProjectRepository
import com.gaganbelgur.domain.usecases.GetAllProjectUseCase
import com.gaganbelgur.domain.usecases.GetProjectTagsUseCase
import com.gaganbelgur.domain.usecases.ProjectUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    fun provideProjectUseCases(repository: ProjectRepository): ProjectUseCase {
        return ProjectUseCase(
            getAllProjectUseCase = GetAllProjectUseCase(repository),
            getProjectTagsUseCase = GetProjectTagsUseCase(repository)
        )
    }
}
