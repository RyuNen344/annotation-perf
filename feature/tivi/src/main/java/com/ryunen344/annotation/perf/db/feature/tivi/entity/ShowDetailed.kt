package com.ryunen344.annotation.perf.db.feature.tivi.entity

import androidx.room.Embedded
import androidx.room.Ignore
import androidx.room.Relation
import java.util.*

class ShowDetailed {
    @Embedded
    lateinit var show: TiviShow

    @Relation(parentColumn = "id", entityColumn = "show_id")
    lateinit var images: List<ShowTmdbImage>

    @delegate:Ignore
    val backdrop: ShowTmdbImage? by lazy(LazyThreadSafetyMode.NONE) {
        images.findHighestRatedBackdrop()
    }

    @delegate:Ignore
    val poster: ShowTmdbImage? by lazy(LazyThreadSafetyMode.NONE) {
        images.findHighestRatedPoster()
    }

    override fun equals(other: Any?): Boolean = when {
        other === this -> true
        other is ShowDetailed -> show == other.show && images == other.images
        else -> false
    }

    override fun hashCode(): Int = Objects.hash(show, images)
}
