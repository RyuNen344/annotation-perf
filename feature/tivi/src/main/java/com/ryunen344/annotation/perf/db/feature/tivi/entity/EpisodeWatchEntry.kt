package com.ryunen344.annotation.perf.db.feature.tivi.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey
import java.time.OffsetDateTime

@Entity(
    tableName = "episode_watch_entries",
    indices = [
        Index(value = ["episode_id"]),
        Index(value = ["trakt_id"], unique = true)
    ],
    foreignKeys = [
        ForeignKey(
            entity = Episode::class,
            parentColumns = arrayOf("id"),
            childColumns = arrayOf("episode_id"),
            onUpdate = ForeignKey.CASCADE,
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class EpisodeWatchEntry(
    @PrimaryKey(autoGenerate = true) override val id: Long = 0,
    @ColumnInfo(name = "episode_id") val episodeId: Long,
    @ColumnInfo(name = "trakt_id") val traktId: Long? = null,
    @ColumnInfo(name = "watched_at") val watchedAt: OffsetDateTime,
    @ColumnInfo(name = "pending_action") val pendingAction: PendingAction = PendingAction.NOTHING
) : TiviEntity
