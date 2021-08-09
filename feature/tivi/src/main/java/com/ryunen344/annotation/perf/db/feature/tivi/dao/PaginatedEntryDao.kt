package com.ryunen344.annotation.perf.db.feature.tivi.dao

import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Transaction
import com.ryunen344.annotation.perf.db.feature.tivi.entity.EntryWithShow
import com.ryunen344.annotation.perf.db.feature.tivi.entity.PaginatedEntry

abstract class PaginatedEntryDao<EC : PaginatedEntry, LI : EntryWithShow<EC>> : EntryDao<EC, LI>() {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract override suspend fun insert(entity: EC): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract override suspend fun insertAll(vararg entity: EC)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract override suspend fun insertAll(entities: List<EC>)

    abstract suspend fun deletePage(page: Int)
    abstract suspend fun getLastPage(): Int?

    @Transaction
    open suspend fun updatePage(page: Int, entities: List<EC>) {
        deletePage(page)
        insertAll(entities)
    }
}
