package com.ryunen344.annotation.perf.db.feature.simple.dao

import androidx.room.Dao
import androidx.room.Query
import com.ryunen344.annotation.perf.db.feature.simple.entity.TimeSet

@Dao
interface TimeSetDao {
    @Query("SELECT * FROM time_set")
    fun selectAll(): List<TimeSet>
}
