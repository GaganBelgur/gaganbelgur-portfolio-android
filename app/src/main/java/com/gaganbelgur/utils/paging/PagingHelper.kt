package com.gaganbelgur.utils.paging

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow

interface PagingHelper {

    fun <T : Any> createPagingFlow(
        pageSize: Int = 20,
        enablePlaceholders: Boolean = true,
        loadData: suspend (offset: Int, limit: Int) -> List<T>
    ): Flow<PagingData<T>>

}