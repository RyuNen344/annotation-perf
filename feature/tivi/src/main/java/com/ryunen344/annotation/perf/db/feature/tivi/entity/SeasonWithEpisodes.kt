package com.ryunen344.annotation.perf.db.feature.tivi.entity

import androidx.room.Embedded
import androidx.room.Relation
import java.util.*

class SeasonWithEpisodes {
    @Embedded
    var season: Season? = null

    @Relation(parentColumn = "id", entityColumn = "season_id")
    var episodes: List<Episode> = emptyList()

    override fun equals(other: Any?): Boolean = when {
        other === this -> true
        other is SeasonWithEpisodes -> season == other.season && episodes == other.episodes
        else -> false
    }

    override fun hashCode(): Int = Objects.hash(season, episodes)
}
