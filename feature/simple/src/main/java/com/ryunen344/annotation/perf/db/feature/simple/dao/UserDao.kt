package com.ryunen344.annotation.perf.db.feature.simple.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.ryunen344.annotation.perf.db.feature.simple.entity.User

@Dao
interface UserDao {
    @Query("SELECT * FROM newbie_user")
    fun getAll(): List<User>

    @Query("SELECT * FROM newbie_user WHERE id IN (:userIds)")
    fun loadAllByIds(userIds: IntArray): List<User>

    @Query(
        "SELECT * FROM newbie_user WHERE first_name LIKE :first AND " +
        "last_name LIKE :last LIMIT 1"
    )
    fun findByName(first: String, last: String): User

    @Insert
    fun insertAll(vararg users: User)

    @Delete
    fun delete(users: User)
}
