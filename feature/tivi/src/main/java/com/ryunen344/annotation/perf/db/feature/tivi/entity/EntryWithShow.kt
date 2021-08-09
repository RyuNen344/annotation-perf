package com.ryunen344.annotation.perf.db.feature.tivi.entity

import java.util.*

interface EntryWithShow<ET : Entry> {
    var entry: ET
    var relations: List<TiviShow>
    var images: List<ShowTmdbImage>

    val show: TiviShow
        get() {
            check(relations.size == 1)
            return relations[0]
        }

    /**
     * @delegate:Ignore
     * val backdrop: ShowTmdbImage? by lazy(LazyThreadSafetyMode.NONE) {
     *     images.findHighestRatedBackdrop()
     * }
     */
    fun backdrop(): ShowTmdbImage? {
        return images.findHighestRatedBackdrop()
    }

    /**
     * @delegate:Ignore
     * override val poster: ShowTmdbImage? by lazy(LazyThreadSafetyMode.NONE) {
     *     images.findHighestRatedPoster()
     * }
     */
    fun poster(): ShowTmdbImage? {
        return images.findHighestRatedPoster()
    }

    fun generateStableId(): Long {
        return Objects.hash(entry::class.java.name, entry.showId).toLong()
    }
}
