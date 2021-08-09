package com.ryunen344.annotation.perf.db.dao.dagashi

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import com.ryunen344.annotation.perf.db.entity.dagashi.MileStoneEntity
import com.ryunen344.annotation.perf.db.entity.dagashi.SummaryIssueEntity
import com.ryunen344.annotation.perf.db.entity.dagashi.combined.MileStoneWithSummaryIssue
import kotlinx.coroutines.flow.Flow

@Dao
abstract class MileStoneDao : BaseDao<MileStoneEntity>() {
    @Transaction
    @Query("SELECT * FROM mile_stone ORDER BY number DESC")
    abstract fun select(): Flow<List<MileStoneWithSummaryIssue>>
}

@Dao
abstract class SummaryIssueDao : BaseDao<SummaryIssueEntity>()
