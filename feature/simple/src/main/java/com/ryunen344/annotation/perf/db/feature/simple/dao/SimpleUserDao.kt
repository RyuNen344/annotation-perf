package com.ryunen344.annotation.perf.db.feature.simple.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.ryunen344.annotation.perf.db.feature.simple.entity.SimpleUser

@Dao
interface SimpleUserDao {
    @Query("SELECT * FROM simple_user")
    fun getAll(): List<SimpleUser>

    @Query("SELECT * FROM simple_user WHERE id IN (:userIds)")
    fun loadAllByIds(userIds: IntArray): List<SimpleUser>

    @Query(
        "SELECT * FROM simple_user WHERE first_name LIKE :first AND " +
        "last_name LIKE :last LIMIT 1"
    )
    fun findByName(first: String, last: String): SimpleUser

    @Insert
    fun insertAll(vararg simpleUsers: SimpleUser)

    @Delete
    fun delete(users: SimpleUser)
}
