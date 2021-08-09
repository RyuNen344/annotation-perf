package com.ryunen344.annotation.perf.db.feature.tivi.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey
import java.time.OffsetDateTime

@Entity(
    tableName = "myshows_entries",
    indices = [
        Index(value = ["show_id"], unique = true)
    ],
    foreignKeys = [
        ForeignKey(
            entity = TiviShow::class,
            parentColumns = arrayOf("id"),
            childColumns = arrayOf("show_id"),
            onUpdate = ForeignKey.CASCADE,
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class FollowedShowEntry(
    @PrimaryKey(autoGenerate = true) override val id: Long = 0,
    @ColumnInfo(name = "show_id") override val showId: Long,
    @ColumnInfo(name = "followed_at") val followedAt: OffsetDateTime? = null,
    @ColumnInfo(name = "pending_action") val pendingAction: PendingAction = PendingAction.NOTHING,
    @ColumnInfo(name = "trakt_id") val traktId: Long? = null
) : Entry
