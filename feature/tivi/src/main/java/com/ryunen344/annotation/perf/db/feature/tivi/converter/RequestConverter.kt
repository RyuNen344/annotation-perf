package com.ryunen344.annotation.perf.db.feature.tivi.converter

import androidx.room.TypeConverter
import com.ryunen344.annotation.perf.db.feature.tivi.entity.Request

object RequestConverter {
    @JvmStatic
    @TypeConverter
    fun fromString(value: String?): Request? {
        return value?.let { tag ->
            Request.values().firstOrNull { it.tag == tag }
        }
    }

    @JvmStatic
    @TypeConverter
    fun toString(value: Request?): String? {
        return value?.tag
    }
}
