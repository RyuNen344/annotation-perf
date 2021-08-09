package com.ryunen344.annotation.perf.db.feature.tivi.dao

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import com.ryunen344.annotation.perf.db.feature.tivi.entity.PopularEntryWithShow
import com.ryunen344.annotation.perf.db.feature.tivi.entity.PopularShowEntry
import kotlinx.coroutines.flow.Flow

@Dao
abstract class PopularDao : PaginatedEntryDao<PopularShowEntry, PopularEntryWithShow>() {
    @Transaction
    @Query("SELECT * FROM popular_shows WHERE page = :page ORDER BY page_order")
    abstract fun entriesObservable(page: Int): Flow<List<PopularShowEntry>>

    @Transaction
    @Query("SELECT * FROM popular_shows ORDER BY page, page_order LIMIT :count OFFSET :offset")
    abstract fun entriesObservable(count: Int, offset: Int): Flow<List<PopularEntryWithShow>>

    @Transaction
    @Query("SELECT * FROM popular_shows ORDER BY page, page_order")
    abstract fun entriesPagingSource(): PagingSource<Int, PopularEntryWithShow>

    @Query("DELETE FROM popular_shows WHERE page = :page")
    abstract override suspend fun deletePage(page: Int)

    @Query("DELETE FROM popular_shows")
    abstract override suspend fun deleteAll()

    @Query("SELECT MAX(page) from popular_shows")
    abstract override suspend fun getLastPage(): Int?
}
