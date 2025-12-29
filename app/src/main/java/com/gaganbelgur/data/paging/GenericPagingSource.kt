package com.gaganbelgur.data.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState

class GenericPagingSource<T : Any>(
    private val pageSize: Int,
    private val loadData: suspend (offset: Int, limit: Int) -> List<T>,
) : PagingSource<Int, T>() {

    override fun getRefreshKey(state: PagingState<Int, T>): Int? {
        return state.anchorPosition?.let { anchor ->
            state.closestPageToPosition(anchor)?.prevKey?.plus(1) ?: state.closestPageToPosition(
                anchor
            )?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, T> {
        return try {
            val currentPage = params.key ?: 0
            val offset = currentPage * pageSize
            val data = loadData(offset, pageSize)

            LoadResult.Page(
                data = data,
                prevKey = if(currentPage == 0) null else currentPage - 1,
                nextKey = if(data.isEmpty()) null else null
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }
}