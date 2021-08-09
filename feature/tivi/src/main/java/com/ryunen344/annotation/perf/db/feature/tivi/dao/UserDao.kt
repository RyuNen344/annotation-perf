package com.ryunen344.annotation.perf.db.feature.tivi.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ryunen344.annotation.perf.db.feature.tivi.entity.TraktUser
import kotlinx.coroutines.flow.Flow

@Dao
abstract class UserDao : EntityDao<TraktUser>() {
    @Query("SELECT * FROM users WHERE is_me != 0")
    abstract fun observeMe(): Flow<TraktUser?>

    @Query("SELECT * FROM users WHERE username = :username")
    abstract fun observeTraktUser(username: String): Flow<TraktUser?>

    @Query("SELECT * FROM users WHERE username = :username")
    abstract suspend fun getTraktUser(username: String): TraktUser?

    @Query("SELECT * FROM users WHERE is_me != 0")
    abstract suspend fun getMe(): TraktUser?

    @Query("SELECT id FROM users WHERE username = :username")
    abstract suspend fun getIdForUsername(username: String): Long?

    @Query("SELECT id FROM users WHERE is_me != 0")
    abstract suspend fun getIdForMe(): Long?

    @Query("DELETE FROM users WHERE username = :username")
    abstract suspend fun deleteWithUsername(username: String)

    @Query("DELETE FROM users WHERE is_me != 0")
    abstract suspend fun deleteMe()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract override suspend fun insert(entity: TraktUser): Long

    @Query("DELETE FROM users")
    abstract suspend fun deleteAll()
}
