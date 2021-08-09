package com.ryunen344.annotation.perf.db.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.ryunen344.annotation.perf.db.converter.LocalDateTimeConverter
import com.ryunen344.annotation.perf.db.converter.OffsetDateTimeConverter
import com.ryunen344.annotation.perf.db.converter.ZonedDateTimeConverter
import com.ryunen344.annotation.perf.db.dao.TimeSetDao
import com.ryunen344.annotation.perf.db.dao.UserDao
import com.ryunen344.annotation.perf.db.entity.TimeSet
import com.ryunen344.annotation.perf.db.entity.User

@Database(
    entities = [
        TimeSet::class,
        User::class
    ],
    version = 1,
    exportSchema = false
)
@TypeConverters(
    value = [
        LocalDateTimeConverter::class,
        OffsetDateTimeConverter::class,
        ZonedDateTimeConverter::class
    ]
)
abstract class PerfDatabase : RoomDatabase() {
    abstract fun timeSetDao(): TimeSetDao
    abstract fun userDao(): UserDao
}
