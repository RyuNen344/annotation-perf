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

    val poster: ShowTmdbImage?

    fun generateStableId(): Long {
        return Objects.hash(entry::class.java.name, entry.showId).toLong()
    }
}
