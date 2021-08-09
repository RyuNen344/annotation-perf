package com.ryunen344.annotation.perf.db.feature.tivi.entity

import androidx.room.Embedded
import androidx.room.Ignore
import androidx.room.Relation
import java.util.*

class RelatedShowEntryWithShow : EntryWithShow<RelatedShowEntry> {
    @Embedded
    override lateinit var entry: RelatedShowEntry

    @Relation(parentColumn = "other_show_id", entityColumn = "id")
    override lateinit var relations: List<TiviShow>

    @Relation(parentColumn = "other_show_id", entityColumn = "show_id")
    override lateinit var images: List<ShowTmdbImage>

    @delegate:Ignore
    val backdrop by lazy(LazyThreadSafetyMode.NONE) {
        images.findHighestRatedBackdrop()
    }

    @delegate:Ignore
    override val poster by lazy(LazyThreadSafetyMode.NONE) {
        images.findHighestRatedPoster()
    }

    override fun equals(other: Any?): Boolean = when {
        other === this -> true
        other is RelatedShowEntryWithShow -> {
            entry == other.entry && relations == other.relations && images == other.images
        }
        else -> false
    }

    override fun hashCode(): Int = Objects.hash(entry, relations, images)
}
