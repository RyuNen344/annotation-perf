package com.ryunen344.annotation.perf.db.feature.tivi.view

import androidx.room.DatabaseView
import com.ryunen344.annotation.perf.db.feature.tivi.entity.Season

@DatabaseView(
    """
    SELECT fs.id, COUNT(*) as episodeCount, COUNT(ew.watched_at) as watchedEpisodeCount
    FROM myshows_entries as fs
    INNER JOIN seasons AS s ON fs.show_id = s.show_id
    INNER JOIN episodes AS eps ON eps.season_id = s.id
    LEFT JOIN episode_watch_entries as ew ON ew.episode_id = eps.id
    WHERE eps.first_aired IS NOT NULL
        AND datetime(eps.first_aired) < datetime('now')
        AND s.number != ${Season.NUMBER_SPECIALS}
        AND s.ignored = 0
    GROUP BY fs.id
"""
)
data class FollowedShowsWatchStats(
    val id: Long,
    val episodeCount: Int,
    val watchedEpisodeCount: Int
)
