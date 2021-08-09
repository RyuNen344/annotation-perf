package com.ryunen344.annotation.perf.db.feature.tivi.entity

data class EpisodeWithSeasonWithShow(
    val episode: Episode,
    val season: Season,
    val show: TiviShow,
    private val images: List<TmdbImageEntity>
) {
    val backdrop by lazy(LazyThreadSafetyMode.NONE) {
        images.findHighestRatedBackdrop()
    }

    val poster by lazy(LazyThreadSafetyMode.NONE) {
        images.findHighestRatedPoster()
    }
}
