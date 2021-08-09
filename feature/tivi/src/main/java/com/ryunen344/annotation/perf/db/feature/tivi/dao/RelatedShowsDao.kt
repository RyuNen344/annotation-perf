package com.ryunen344.annotation.perf.db.feature.tivi.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import com.ryunen344.annotation.perf.db.feature.tivi.entity.RelatedShowEntry
import com.ryunen344.annotation.perf.db.feature.tivi.entity.RelatedShowEntryWithShow
import kotlinx.coroutines.flow.Flow

@Dao
abstract class RelatedShowsDao : PairEntryDao<RelatedShowEntry, RelatedShowEntryWithShow>() {
    @Transaction
    @Query("SELECT * FROM related_shows WHERE show_id = :showId ORDER BY order_index")
    abstract override fun entries(showId: Long): List<RelatedShowEntry>

    @Transaction
    @Query("SELECT * FROM related_shows WHERE show_id = :showId ORDER BY order_index")
    abstract fun entriesObservable(showId: Long): Flow<List<RelatedShowEntry>>

    @Transaction
    @Query("SELECT * FROM related_shows WHERE show_id = :showId ORDER BY order_index")
    abstract override fun entriesWithShows(showId: Long): List<RelatedShowEntryWithShow>

    @Transaction
    @Query("SELECT * FROM related_shows WHERE show_id = :showId ORDER BY order_index")
    abstract override fun entriesWithShowsObservable(showId: Long): Flow<List<RelatedShowEntryWithShow>>

    @Query("DELETE FROM related_shows WHERE show_id = :showId")
    abstract override suspend fun deleteWithShowId(showId: Long)

    @Query("DELETE FROM related_shows")
    abstract suspend fun deleteAll()
}
