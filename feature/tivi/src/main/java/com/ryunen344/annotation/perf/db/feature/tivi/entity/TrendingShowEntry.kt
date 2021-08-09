package com.ryunen344.annotation.perf.db.feature.tivi.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "trending_shows",
    indices = [
        Index(value = ["show_id"], unique = true)
    ],
    foreignKeys = [
        ForeignKey(
            entity = TiviShow::class,
            parentColumns = arrayOf("id"),
            childColumns = arrayOf("show_id"),
            onUpdate = ForeignKey.CASCADE,
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class TrendingShowEntry(
    @PrimaryKey(autoGenerate = true)
    override val id: Long = 0,
    @ColumnInfo(name = "show_id")
    override val showId: Long,
    @ColumnInfo(name = "page")
    override val page: Int,
    @ColumnInfo(name = "watchers")
    val watchers: Int
) : PaginatedEntry
