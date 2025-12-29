package com.gaganbelgur.di

import com.gaganbelgur.data.repository.ProjectRepositoryImpl
import com.gaganbelgur.domain.repository.ProjectRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideProjectRepository(): ProjectRepository = ProjectRepositoryImpl()

}