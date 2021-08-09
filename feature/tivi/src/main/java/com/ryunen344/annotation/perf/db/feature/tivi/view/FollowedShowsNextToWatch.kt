package com.ryunen344.annotation.perf.db.feature.tivi.view

import androidx.room.DatabaseView
import com.ryunen344.annotation.perf.db.feature.tivi.entity.Season
import java.time.OffsetDateTime

@DatabaseView(
    value =
    """
SELECT
  fs.id,
  MIN(datetime(eps.first_aired)) AS next_ep_to_watch_air_date
FROM
  myshows_entries as fs
  INNER JOIN seasons AS s ON fs.show_id = s.show_id
  INNER JOIN episodes AS eps ON eps.season_id = s.id
  LEFT JOIN episode_watch_entries as ew ON ew.episode_id = eps.id
  INNER JOIN followed_last_watched_airdate AS lw ON lw.id = fs.id
WHERE
  s.number != ${Season.NUMBER_SPECIALS}
  AND s.ignored = 0
  AND watched_at IS NULL
  AND datetime(first_aired) < datetime('now')
  AND datetime(first_aired) > datetime(last_watched_air_date)
GROUP BY
  fs.id
""",
    viewName = "followed_next_to_watch"
)
data class FollowedShowsNextToWatch(
    val id: Long,
    val nextEpisodeToWatchAirDate: OffsetDateTime?
)
