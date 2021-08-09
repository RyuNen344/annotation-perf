package com.ryunen344.annotation.perf.db.feature.tivi.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "show_images",
    indices = [
        Index(value = ["show_id"])
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
data class ShowTmdbImage(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id") override val id: Long = 0,
    @ColumnInfo(name = "show_id") val showId: Long,
    @ColumnInfo(name = "path") override val path: String,
    @ColumnInfo(name = "type") override val type: ImageType,
    @ColumnInfo(name = "lang") override val language: String? = null,
    @ColumnInfo(name = "rating") override val rating: Float = 0f,
    @ColumnInfo(name = "is_primary") override val isPrimary: Boolean = false
) : TiviEntity, TmdbImageEntity
