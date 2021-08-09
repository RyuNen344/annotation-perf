package com.ryunen344.annotation.perf.db.feature.tivi.entity

import androidx.room.Embedded
import androidx.room.Relation
import java.util.*

class SeasonWithShow {
    @Embedded
    lateinit var season: Season

    @Relation(parentColumn = "show_id", entityColumn = "id")
    var _shows: List<TiviShow> = emptyList()

    val show: TiviShow
        get() {
            require(_shows.size == 1)
            return _shows[0]
        }

    override fun equals(other: Any?): Boolean = when {
        other === this -> true
        other is SeasonWithShow -> season == other.season && _shows == other._shows
        else -> false
    }

    override fun hashCode(): Int = Objects.hash(season, _shows)
}
