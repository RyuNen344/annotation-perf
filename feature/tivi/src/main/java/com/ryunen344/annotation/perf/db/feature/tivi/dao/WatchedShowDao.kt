package com.ryunen344.annotation.perf.db.feature.tivi.dao

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import com.ryunen344.annotation.perf.db.feature.tivi.entity.SortOption
import com.ryunen344.annotation.perf.db.feature.tivi.entity.WatchedShowEntry
import com.ryunen344.annotation.perf.db.feature.tivi.entity.WatchedShowEntryWithShow
import kotlinx.coroutines.flow.Flow

@Dao
abstract class WatchedShowDao : EntryDao<WatchedShowEntry, WatchedShowEntryWithShow>() {
    @Transaction
    @Query("SELECT * FROM watched_entries WHERE show_id = :showId")
    abstract suspend fun entryWithShowId(showId: Long): WatchedShowEntry?

    @Transaction
    @Query(ENTRY_QUERY_ORDER_LAST_WATCHED)
    abstract suspend fun entries(): List<WatchedShowEntry>

    @Transaction
    @Query(ENTRY_QUERY_ORDER_LAST_WATCHED)
    abstract fun entriesObservable(): Flow<List<WatchedShowEntry>>

    fun observePagedList(
        filter: String?,
        sort: SortOption
    ): PagingSource<Int, WatchedShowEntryWithShow> {
        val filtered = filter != null && filter.isNotEmpty()
        return when (sort) {
            SortOption.LAST_WATCHED -> {
                if (filtered) {
                    pagedListLastWatchedFilter("*$filter*")
                } else {
                    pagedListLastWatched()
                }
            }
            SortOption.ALPHABETICAL -> {
                if (filtered) {
                    pagedListAlphaFilter("*$filter*")
                } else {
                    pagedListAlpha()
                }
            }
            else -> throw IllegalArgumentException("$sort option is not supported")
        }
    }

    @Transaction
    @Query(ENTRY_QUERY_ORDER_LAST_WATCHED)
    protected abstract fun pagedListLastWatched(): PagingSource<Int, WatchedShowEntryWithShow>

    @Transaction
    @Query(ENTRY_QUERY_ORDER_LAST_WATCHED_FILTER)
    protected abstract fun pagedListLastWatchedFilter(filter: String): PagingSource<Int, WatchedShowEntryWithShow>

    @Transaction
    @Query(ENTRY_QUERY_ORDER_ALPHA)
    protected abstract fun pagedListAlpha(): PagingSource<Int, WatchedShowEntryWithShow>

    @Transaction
    @Query(ENTRY_QUERY_ORDER_ALPHA_FILTER)
    protected abstract fun pagedListAlphaFilter(filter: String): PagingSource<Int, WatchedShowEntryWithShow>

    @Query("DELETE FROM watched_entries")
    abstract override suspend fun deleteAll()

    companion object {
        private const val ENTRY_QUERY_ORDER_LAST_WATCHED =
            """
            SELECT we.* FROM watched_entries as we
            ORDER BY datetime(last_watched) DESC
        """

        private const val ENTRY_QUERY_ORDER_LAST_WATCHED_FILTER =
            """
            SELECT we.* FROM watched_entries as we
            INNER JOIN shows_fts AS fts ON we.show_id = fts.docid
            WHERE fts.title MATCH :filter
            ORDER BY datetime(last_watched) DESC
        """

        private const val ENTRY_QUERY_ORDER_ALPHA =
            """
            SELECT we.* FROM watched_entries as we
            INNER JOIN shows_fts AS fts ON we.show_id = fts.docid
            ORDER BY title ASC
        """

        private const val ENTRY_QUERY_ORDER_ALPHA_FILTER =
            """
            SELECT we.* FROM watched_entries as we
            INNER JOIN shows_fts AS fts ON we.show_id = fts.docid
            WHERE title MATCH :filter
            ORDER BY title ASC
        """
    }
}
