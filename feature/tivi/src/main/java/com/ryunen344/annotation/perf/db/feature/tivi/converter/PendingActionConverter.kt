package com.ryunen344.annotation.perf.db.feature.tivi.converter

import androidx.room.TypeConverter
import com.ryunen344.annotation.perf.db.feature.tivi.entity.PendingAction

object PendingActionConverter {
    @TypeConverter
    fun fromString(value: String?): PendingAction? {
        return value?.let {
            PendingAction.values().firstOrNull { it.value == value }
        }
    }

    @TypeConverter
    fun toString(value: PendingAction?): String? {
        return value?.value
    }
}
