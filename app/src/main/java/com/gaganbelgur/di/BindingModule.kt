package com.gaganbelgur.di

import com.gaganbelgur.utils.paging.DefaultPagingHelper
import com.gaganbelgur.utils.paging.PagingHelper
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class BindingModule {

    @Binds
    abstract fun bindPagingHelper(
        defaultPagingHelper: DefaultPagingHelper
    ): PagingHelper

}