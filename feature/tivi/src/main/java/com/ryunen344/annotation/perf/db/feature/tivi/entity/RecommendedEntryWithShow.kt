package com.ryunen344.annotation.perf.db.feature.tivi.entity

import androidx.room.Embedded
import androidx.room.Relation
import java.util.*

class RecommendedEntryWithShow : EntryWithShow<RecommendedShowEntry> {
    @Embedded
    override lateinit var entry: RecommendedShowEntry

    @Relation(parentColumn = "show_id", entityColumn = "id")
    override lateinit var relations: List<TiviShow>

    @Relation(parentColumn = "show_id", entityColumn = "show_id")
    override lateinit var images: List<ShowTmdbImage>

    override fun equals(other: Any?): Boolean = when {
        other === this -> true
        other is RecommendedEntryWithShow -> {
            entry == other.entry && relations == other.relations && images == other.images
        }
        else -> false
    }

    override fun hashCode(): Int = Objects.hash(entry, relations, images)
}
