package com.ryunen344.annotation.perf.db.feature.tivi.entity

interface Entry : TiviEntity {
    val showId: Long
}

interface MultipleEntry : Entry {
    val otherShowId: Long
}

interface PaginatedEntry : Entry {
    val page: Int
}
