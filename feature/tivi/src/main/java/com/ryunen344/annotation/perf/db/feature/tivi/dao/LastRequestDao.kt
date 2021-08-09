package com.ryunen344.annotation.perf.db.feature.tivi.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.ryunen344.annotation.perf.db.feature.tivi.entity.LastRequest
import com.ryunen344.annotation.perf.db.feature.tivi.entity.Request

@Dao
abstract class LastRequestDao : EntityDao<LastRequest>() {
    @Query("SELECT * FROM last_requests WHERE request = :request AND entity_id = :entityId")
    abstract suspend fun lastRequest(request: Request, entityId: Long): LastRequest?

    @Query("SELECT COUNT(*) FROM last_requests WHERE request = :request AND entity_id = :entityId")
    abstract suspend fun requestCount(request: Request, entityId: Long): Int

    @Transaction
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract override suspend fun insert(entity: LastRequest): Long
}
