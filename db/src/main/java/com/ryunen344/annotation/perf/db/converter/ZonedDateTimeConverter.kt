package com.ryunen344.annotation.perf.db.converter

import androidx.room.TypeConverter
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter

object ZonedDateTimeConverter {
    @TypeConverter
    fun fromString(value: String?): ZonedDateTime? {
        return value?.let {
            ZonedDateTime.parse(it, DateTimeFormatter.ISO_ZONED_DATE_TIME)
        }
    }

    @TypeConverter
    fun toString(value: ZonedDateTime?): String? {
        return value?.let {
            DateTimeFormatter.ISO_ZONED_DATE_TIME.format(it)
        }
    }
}
