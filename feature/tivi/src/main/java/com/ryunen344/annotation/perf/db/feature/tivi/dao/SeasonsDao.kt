package com.ryunen344.annotation.perf.db.feature.tivi.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import com.ryunen344.annotation.perf.db.feature.tivi.entity.Season
import com.ryunen344.annotation.perf.db.feature.tivi.entity.Season.Companion.NUMBER_SPECIALS
import com.ryunen344.annotation.perf.db.feature.tivi.entity.SeasonWithEpisodesAndWatches
import kotlinx.coroutines.flow.Flow

@Dao
abstract class SeasonsDao : EntityDao<Season>() {
    @Transaction
    @Query("SELECT * FROM seasons WHERE show_id = :showId ORDER BY number=$NUMBER_SPECIALS, number")
    abstract fun seasonsWithEpisodesForShowId(showId: Long): Flow<List<SeasonWithEpisodesAndWatches>>

    @Query("SELECT * FROM seasons WHERE show_id = :showId ORDER BY number=$NUMBER_SPECIALS, number")
    abstract fun observeSeasonsForShowId(showId: Long): Flow<List<Season>>

    @Query("SELECT * FROM seasons WHERE show_id = :showId ORDER BY number=$NUMBER_SPECIALS, number")
    abstract suspend fun seasonsForShowId(showId: Long): List<Season>

    @Transaction
    @Query("SELECT * FROM seasons WHERE id = :seasonId")
    abstract fun seasonWithEpisodes(seasonId: Long): Flow<SeasonWithEpisodesAndWatches>

    @Query("DELETE FROM seasons WHERE show_id = :showId")
    abstract suspend fun deleteWithShowId(showId: Long)

    @Query("DELETE FROM seasons WHERE show_id = :showId")
    abstract suspend fun deleteSeasonsForShowId(showId: Long): Int

    @Query("SELECT * FROM seasons WHERE id = :id")
    abstract suspend fun seasonWithId(id: Long): Season?

    @Query("SELECT trakt_id FROM seasons WHERE id = :id")
    abstract suspend fun traktIdForId(id: Long): Int?

    @Query("SELECT * FROM seasons WHERE trakt_id = :traktId")
    abstract suspend fun seasonWithTraktId(traktId: Int): Season?

    @Query(
        """
        SELECT id from seasons WHERE
          show_id = (SELECT show_id from SEASONS WHERE id = :seasonId)
          AND number != $NUMBER_SPECIALS
          AND number < (SELECT number from SEASONS WHERE id = :seasonId)
    """
    )
    abstract suspend fun showPreviousSeasonIds(seasonId: Long): LongArray

    @Query("UPDATE seasons SET ignored = :ignored WHERE id = :seasonId")
    abstract suspend fun updateSeasonIgnoreFlag(seasonId: Long, ignored: Boolean)

    @Query("SELECT * FROM seasons WHERE show_id = :showId AND number = :number")
    abstract suspend fun seasonWithShowIdAndNumber(showId: Long, number: Int): Season?
}
