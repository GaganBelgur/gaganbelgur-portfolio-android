package com.gaganbelgur.utils.paging

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.gaganbelgur.data.paging.GenericPagingSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class DefaultPagingHelper @Inject constructor() : PagingHelper {

    override fun <T : Any> createPagingFlow(
        pageSize: Int,
        enablePlaceholders: Boolean,
        loadData: suspend (Int, Int) -> List<T>,
    ): Flow<PagingData<T>> {
        return Pager(
            config = PagingConfig(pageSize = pageSize, enablePlaceholders = enablePlaceholders),
            pagingSourceFactory = {
                GenericPagingSource(
                    pageSize = pageSize,
                    loadData = loadData
                )
            }
        ).flow
    }
}