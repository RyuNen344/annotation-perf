package com.ryunen344.annotation.perf.db.feature.tivi.dao

import androidx.room.Dao
import androidx.room.Query
import com.ryunen344.annotation.perf.db.feature.tivi.entity.EpisodeWatchEntry
import com.ryunen344.annotation.perf.db.feature.tivi.entity.PendingAction
import kotlinx.coroutines.flow.Flow

@Dao
abstract class EpisodeWatchEntryDao : EntityDao<EpisodeWatchEntry>() {
    @Query("SELECT * FROM episode_watch_entries WHERE episode_id = :episodeId")
    abstract suspend fun watchesForEpisode(episodeId: Long): List<EpisodeWatchEntry>

    @Query("SELECT COUNT(id) FROM episode_watch_entries WHERE episode_id = :episodeId")
    abstract suspend fun watchCountForEpisode(episodeId: Long): Int

    @Query("SELECT * FROM episode_watch_entries WHERE episode_id = :episodeId")
    abstract fun watchesForEpisodeObservable(episodeId: Long): Flow<List<EpisodeWatchEntry>>

    @Query("SELECT * FROM episode_watch_entries WHERE id = :id")
    abstract suspend fun entryWithId(id: Long): EpisodeWatchEntry?

    @Query("SELECT * FROM episode_watch_entries WHERE trakt_id = :traktId")
    abstract suspend fun entryWithTraktId(traktId: Long): EpisodeWatchEntry?

    @Query("SELECT id FROM episode_watch_entries WHERE trakt_id = :traktId")
    abstract suspend fun entryIdWithTraktId(traktId: Long): Long?

    suspend fun entriesForShowIdWithNoPendingAction(showId: Long): List<EpisodeWatchEntry> {
        return entriesForShowIdWithPendingAction(showId, PendingAction.NOTHING.value)
    }

    suspend fun entriesForShowIdWithSendPendingActions(showId: Long): List<EpisodeWatchEntry> {
        return entriesForShowIdWithPendingAction(showId, PendingAction.UPLOAD.value)
    }

    suspend fun entriesForShowIdWithDeletePendingActions(showId: Long): List<EpisodeWatchEntry> {
        return entriesForShowIdWithPendingAction(showId, PendingAction.DELETE.value)
    }

    @Query(
        """
        SELECT ew.* FROM episode_watch_entries AS ew
        INNER JOIN episodes AS eps ON ew.episode_id = eps.id
        INNER JOIN seasons AS s ON eps.season_id = s.id
        INNER JOIN shows ON s.show_id = shows.id
        WHERE shows.id = :showId AND ew.pending_action = :pendingAction
    """
    )
    internal abstract suspend fun entriesForShowIdWithPendingAction(
        showId: Long,
        pendingAction: String
    ): List<EpisodeWatchEntry>

    @Query(
        """
        SELECT ew.* FROM episode_watch_entries AS ew
        INNER JOIN episodes AS eps ON ew.episode_id = eps.id
        INNER JOIN seasons AS s ON eps.season_id = s.id
        INNER JOIN shows ON s.show_id = shows.id
        WHERE shows.id = :showId
    """
    )
    abstract suspend fun entriesForShowId(showId: Long): List<EpisodeWatchEntry>

    @Query("UPDATE episode_watch_entries SET pending_action = :pendingAction WHERE id IN (:ids)")
    abstract suspend fun updateEntriesToPendingAction(ids: List<Long>, pendingAction: String): Int

    @Query("DELETE FROM episode_watch_entries WHERE id = :id")
    abstract suspend fun deleteWithId(id: Long): Int

    @Query("DELETE FROM episode_watch_entries WHERE id IN (:ids)")
    abstract suspend fun deleteWithIds(ids: List<Long>): Int

    @Query("DELETE FROM episode_watch_entries WHERE trakt_id = :traktId")
    abstract suspend fun deleteWithTraktId(traktId: Long): Int
}
