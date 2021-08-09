package com.ryunen344.annotation.perf.db.feature.tivi.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import java.time.OffsetDateTime

@Entity(
    tableName = "users",
    indices = [Index(value = ["username"], unique = true)]
)
data class TraktUser(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id") override val id: Long = 0,
    @ColumnInfo(name = "username") val username: String,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "joined_date") val joined: OffsetDateTime? = null,
    @ColumnInfo(name = "location") val location: String? = null,
    @ColumnInfo(name = "about") val about: String? = null,
    @ColumnInfo(name = "avatar_url") val avatarUrl: String? = null,
    @ColumnInfo(name = "vip") val vip: Boolean? = null,
    @ColumnInfo(name = "is_me") val isMe: Boolean = false
) : TiviEntity
