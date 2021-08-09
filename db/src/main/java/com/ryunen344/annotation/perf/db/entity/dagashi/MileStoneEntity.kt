package com.ryunen344.annotation.perf.db.entity.dagashi

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.OffsetDateTime

@Entity(tableName = "mile_stone")
data class MileStoneEntity(
    @PrimaryKey
    @ColumnInfo(name = "id")
    val id: String,
    @ColumnInfo(name = "number")
    val number: Int,
    @ColumnInfo(name = "url")
    val url: String,
    @ColumnInfo(name = "title")
    val title: String,
    @ColumnInfo(name = "description")
    val description: String,
    @ColumnInfo(name = "closed_at")
    val closedAt: OffsetDateTime,
    @ColumnInfo(name = "path")
    val path: String
)
