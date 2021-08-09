package com.ryunen344.annotation.perf.db.feature.tivi.dao

import com.ryunen344.annotation.perf.db.feature.tivi.entity.Entry
import com.ryunen344.annotation.perf.db.feature.tivi.entity.EntryWithShow

/**
 * This interface represents a DAO which contains entities which are part of a single collective list.
 */
abstract class EntryDao<EC : Entry, LI : EntryWithShow<EC>> : EntityDao<EC>() {
    abstract suspend fun deleteAll()
}
