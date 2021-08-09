package com.ryunen344.annotation.perf.db.feature.tivi.entity

import androidx.room.Embedded
import androidx.room.Relation
import java.util.*

class EpisodeWithSeason {
    @Embedded
    var episode: Episode? = null

    @Relation(parentColumn = "season_id", entityColumn = "id")
    var _seasons: List<Season> = emptyList()

    /**
     * val season: Season?
     *     get() = _seasons.getOrNull(0)
     */
    fun season(): Season? {
        return _seasons.getOrNull(0)
    }

    override fun equals(other: Any?): Boolean = when {
        other === this -> true
        other is EpisodeWithSeason -> episode == other.episode && _seasons == other._seasons
        else -> false
    }

    override fun hashCode(): Int = Objects.hash(episode, _seasons)
}
