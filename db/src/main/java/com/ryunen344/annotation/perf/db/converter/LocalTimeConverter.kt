package com.ryunen344.annotation.perf.db.converter

import androidx.room.TypeConverter
import java.time.LocalTime
import java.time.format.DateTimeFormatter

object LocalTimeConverter {
    @TypeConverter
    fun fromString(value: String?): LocalTime? {
        return value?.let {
            LocalTime.parse(it, DateTimeFormatter.ISO_LOCAL_TIME)
        }
    }

    @TypeConverter
    fun toString(value: LocalTime?): String? {
        return value?.let {
            DateTimeFormatter.ISO_LOCAL_TIME.format(it)
        }
    }
}
