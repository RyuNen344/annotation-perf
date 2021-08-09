package com.ryunen344.annotation.perf.db.converter

import androidx.room.TypeConverter
import java.time.ZoneId

object ZoneIdConverter {
    @JvmStatic
    @TypeConverter
    fun fromString(value: String?): ZoneId? {
        return value?.let { ZoneId.of(it) }
    }

    @JvmStatic
    @TypeConverter
    fun toString(value: ZoneId?): String? {
        return value?.id
    }
}
