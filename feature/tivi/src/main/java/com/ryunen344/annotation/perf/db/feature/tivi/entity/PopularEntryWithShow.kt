package com.ryunen344.annotation.perf.db.feature.tivi.entity

import androidx.room.Embedded
import androidx.room.Ignore
import androidx.room.Relation
import java.util.*

class PopularEntryWithShow : EntryWithShow<PopularShowEntry> {
    @Embedded
    override lateinit var entry: PopularShowEntry

    @Relation(parentColumn = "show_id", entityColumn = "id")
    override lateinit var relations: List<TiviShow>

    @Relation(parentColumn = "show_id", entityColumn = "show_id")
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
        other is PopularEntryWithShow -> {
            entry == other.entry && relations == other.relations && images == other.images
        }
        else -> false
    }

    override fun hashCode(): Int = Objects.hash(entry, relations, images)
}
