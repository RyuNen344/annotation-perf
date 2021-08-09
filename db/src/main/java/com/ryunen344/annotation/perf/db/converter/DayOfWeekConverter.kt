package com.ryunen344.annotation.perf.db.converter

import androidx.room.TypeConverter
import java.time.DayOfWeek

object DayOfWeekConverter {
    @TypeConverter
    fun fromInt(value: Int?): DayOfWeek? {
        return value?.let {
            DayOfWeek.values().firstOrNull { it.value == value }
        }
    }

    @TypeConverter
    fun toInt(value: DayOfWeek?): Int? {
        return value?.value
    }
}
