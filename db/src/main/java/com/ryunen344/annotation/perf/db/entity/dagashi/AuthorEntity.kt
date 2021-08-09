package com.ryunen344.annotation.perf.db.entity.dagashi

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(tableName = "author")
data class AuthorEntity(
    @ColumnInfo(name = "login")
    val login: String,
    @ColumnInfo(name = "url")
    val url: String,
    @ColumnInfo(name = "avatar_url")
    val avatarUrl: String
)
