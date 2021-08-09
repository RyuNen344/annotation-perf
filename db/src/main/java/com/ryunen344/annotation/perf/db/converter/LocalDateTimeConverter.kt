package com.ryunen344.annotation.perf.db.converter

import androidx.room.TypeConverter
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

object LocalDateTimeConverter {
    @JvmStatic
    @TypeConverter
    fun fromString(value: String?): LocalDateTime? {
        return value?.let {
            LocalDateTime.parse(it, DateTimeFormatter.ISO_LOCAL_DATE_TIME)
        }
    }

    @JvmStatic
    @TypeConverter
    fun toString(value: LocalDateTime?): String? {
        return value?.let {
            DateTimeFormatter.ISO_LOCAL_DATE_TIME.format(it)
        }
    }
}
