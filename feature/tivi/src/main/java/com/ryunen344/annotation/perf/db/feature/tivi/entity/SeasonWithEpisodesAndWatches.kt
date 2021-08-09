package com.ryunen344.annotation.perf.db.feature.tivi.entity

import androidx.room.Embedded
import androidx.room.Relation
import java.util.*

class SeasonWithEpisodesAndWatches {
    @Embedded
    lateinit var season: Season

    @Relation(parentColumn = "id", entityColumn = "season_id", entity = Episode::class)
    var episodes: List<EpisodeWithWatches> = emptyList()

    override fun equals(other: Any?): Boolean = when {
        other === this -> true
        other is SeasonWithEpisodesAndWatches -> season == other.season && episodes == other.episodes
        else -> false
    }

    override fun hashCode(): Int = Objects.hash(season, episodes)
}

val List<EpisodeWithWatches>.numberAiredToWatch: Int
    get() = count { !it.isWatched && it.episode.isAired }

val List<EpisodeWithWatches>.numberWatched: Int
    get() = count { it.isWatched }

val List<EpisodeWithWatches>.numberToAir: Int
    get() = size - numberAired

val List<EpisodeWithWatches>.numberAired: Int
    get() = count { it.episode.isAired }

val List<EpisodeWithWatches>.nextToAir: Episode?
    get() = firstOrNull {
        it.episode.let { ep -> !ep.isAired && ep.firstAired != null }
    }?.episode
