package com.ryunen344.annotation.perf.db.feature.tivi.converter

import androidx.room.TypeConverter
import com.ryunen344.annotation.perf.db.feature.tivi.entity.ShowStatus

object ShowStatusConverter {
    @TypeConverter
    fun fromString(value: String?): ShowStatus? {
        return value?.let { storageKey ->
            ShowStatus.values().firstOrNull { it.storageKey == storageKey }
        }
    }

    @TypeConverter
    fun toString(value: ShowStatus?): String? {
        return value?.storageKey
    }
}
