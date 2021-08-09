package com.ryunen344.annotation.perf.db.feature.tivi.entity

import androidx.room.Embedded
import androidx.room.Relation
import java.time.OffsetDateTime
import java.util.*

class EpisodeWithWatches {
    @Embedded
    lateinit var episode: Episode

    @Relation(parentColumn = "id", entityColumn = "episode_id")
    lateinit var watches: List<EpisodeWatchEntry>

    /**
     * @delegate:Ignore
     * val hasWatches by lazy { watches.isNotEmpty() }
     */
    fun hasWatches(): Boolean {
        return watches.isNotEmpty()
    }

    /**
     * @delegate:Ignore
     *     watches.any { it.pendingAction != PendingAction.DELETE }
     * }
     */
    fun isWatched(): Boolean {
        return watches.any { it.pendingAction != PendingAction.DELETE }
    }

    /**
     * @delegate:Ignore
     * val hasPending by lazy {
     *     watches.any { it.pendingAction != PendingAction.NOTHING }
     * }
     */
    fun hasPending(): Boolean {
        return watches.any { it.pendingAction != PendingAction.NOTHING }
    }

    /**
     * @delegate:Ignore
     * val onlyPendingDeletes by lazy {
     *     watches.all { it.pendingAction == PendingAction.DELETE }
     * }
     */
    fun isOnlyPendingDeletes(): Boolean {
        return watches.all { it.pendingAction == PendingAction.DELETE }
    }

    /**
     * @delegate:Ignore
     * val hasAired by lazy {
     *     val aired = episode.firstAired
     *     aired != null && aired.isBefore(OffsetDateTime.now())
     * }
     */
    fun hasAired(): Boolean {
        val aired = episode.firstAired
        return aired != null && aired.isBefore(OffsetDateTime.now())
    }

    override fun equals(other: Any?): Boolean = when {
        other === this -> true
        other is EpisodeWithWatches -> watches == other.watches && episode == other.episode
        else -> false
    }

    override fun hashCode(): Int = Objects.hash(episode, watches)
}
