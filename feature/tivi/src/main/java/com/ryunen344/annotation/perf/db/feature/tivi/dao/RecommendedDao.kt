package com.ryunen344.annotation.perf.db.feature.tivi.dao

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import com.ryunen344.annotation.perf.db.feature.tivi.entity.RecommendedEntryWithShow
import com.ryunen344.annotation.perf.db.feature.tivi.entity.RecommendedShowEntry
import kotlinx.coroutines.flow.Flow

@Dao
abstract class RecommendedDao : PaginatedEntryDao<RecommendedShowEntry, RecommendedEntryWithShow>() {
    @Transaction
    @Query("SELECT * FROM recommended_entries WHERE page = :page ORDER BY id ASC")
    abstract fun entriesForPage(page: Int): Flow<List<RecommendedShowEntry>>

    @Transaction
    @Query("SELECT * FROM recommended_entries ORDER BY page ASC, id ASC LIMIT :count OFFSET :offset")
    abstract fun entriesObservable(count: Int, offset: Int): Flow<List<RecommendedEntryWithShow>>

    @Transaction
    @Query("SELECT * FROM recommended_entries ORDER BY page ASC, id ASC")
    abstract fun entriesPagingSource(): PagingSource<Int, RecommendedEntryWithShow>

    @Query("DELETE FROM recommended_entries WHERE page = :page")
    abstract override suspend fun deletePage(page: Int)

    @Query("DELETE FROM recommended_entries")
    abstract override suspend fun deleteAll()

    @Query("SELECT MAX(page) from recommended_entries")
    abstract override suspend fun getLastPage(): Int?
}
