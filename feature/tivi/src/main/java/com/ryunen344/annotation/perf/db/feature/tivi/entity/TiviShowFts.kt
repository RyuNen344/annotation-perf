package com.ryunen344.annotation.perf.db.feature.tivi.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Fts4

@Fts4(contentEntity = TiviShow::class)
@Entity(tableName = "shows_fts")
data class TiviShowFts(
    @ColumnInfo(name = "title") val title: String? = null,
    @ColumnInfo(name = "original_title") val originalTitle: String? = null
)
