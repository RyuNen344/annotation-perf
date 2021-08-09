package com.ryunen344.annotation.perf.db.converter

import androidx.room.TypeConverter
import java.util.*

object CalendarConverter {
    @JvmStatic
    @TypeConverter
    fun fromLong(value: Long): Calendar {
        return Calendar.getInstance().apply { timeInMillis = value }
    }

    @JvmStatic
    @TypeConverter
    fun toLong(value: Calendar): Long {
        return value.timeInMillis
    }
}
