package com.ryunen344.annotation.perf.db.feature.tivi.dao

import com.ryunen344.annotation.perf.db.feature.tivi.entity.EntryWithShow
import com.ryunen344.annotation.perf.db.feature.tivi.entity.MultipleEntry
import kotlinx.coroutines.flow.Flow

/**
 * This interface represents a DAO which contains entities which are part of a collective list for a given show.
 */
abstract class PairEntryDao<EC : MultipleEntry, LI : EntryWithShow<EC>> : EntityDao<EC>() {
    abstract fun entries(showId: Long): List<EC>
    abstract fun entriesWithShows(showId: Long): List<LI>
    abstract fun entriesWithShowsObservable(showId: Long): Flow<List<LI>>
    abstract suspend fun deleteWithShowId(showId: Long)
}
