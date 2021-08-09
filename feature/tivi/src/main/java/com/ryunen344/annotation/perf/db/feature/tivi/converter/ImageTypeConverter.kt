package com.ryunen344.annotation.perf.db.feature.tivi.converter

import androidx.room.TypeConverter
import com.ryunen344.annotation.perf.db.feature.tivi.entity.ImageType

object ImageTypeConverter {
    @JvmStatic
    @TypeConverter
    fun fromString(value: String?): ImageType? {
        return value?.let { storageKey ->
            ImageType.values().firstOrNull { it.storageKey == storageKey }
        }
    }

    @JvmStatic
    @TypeConverter
    fun toString(value: ImageType?): String? {
        return value?.storageKey
    }
}
