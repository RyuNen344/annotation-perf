package com.ryunen344.annotation.perf.db.converter

import androidx.room.TypeConverter
import java.time.Instant

object InstantConverter {
    @TypeConverter
    fun fromLong(value: Long?): Instant? {
        return value?.let { Instant.ofEpochMilli(it) }
    }

    @TypeConverter
    fun toLong(value: Instant?): Long? {
        return value?.toEpochMilli()
    }
}
