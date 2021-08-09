package com.ryunen344.annotation.perf.db.feature.tivi.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import com.ryunen344.annotation.perf.db.feature.tivi.entity.ShowDetailed

@Dao
abstract class ShowFtsDao {
    @Transaction
    @Query(
        """
        SELECT s.* FROM shows as s
        INNER JOIN shows_fts AS fts ON s.id = fts.docid
        WHERE fts.title MATCH :filter
        """
    )
    abstract suspend fun search(filter: String): List<ShowDetailed>
}
