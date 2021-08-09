package com.ryunen344.annotation.perf.db.dao

import androidx.room.Dao
import androidx.room.Query
import com.ryunen344.annotation.perf.db.entity.TimeSet

@Dao
interface TimeSetDao {
    @Query("SELECT * FROM time_set")
    fun selectAll(): List<TimeSet>
}
