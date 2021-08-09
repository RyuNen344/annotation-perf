package com.ryunen344.annotation.perf.db.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ryunen344.annotation.perf.db.dao.UserDao
import com.ryunen344.annotation.perf.db.entity.User

@Database(entities = [User::class], version = 1, exportSchema = false)
abstract class PerfDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}
