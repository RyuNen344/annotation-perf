package com.ryunen344.annotation.perf.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDateTime
import java.time.OffsetDateTime
import java.time.ZonedDateTime

@Entity(tableName = "time_set")
data class TimeSet(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val localDateTime: LocalDateTime,
    val offsetDateTime: OffsetDateTime,
    val zonedDateTime: ZonedDateTime
)
