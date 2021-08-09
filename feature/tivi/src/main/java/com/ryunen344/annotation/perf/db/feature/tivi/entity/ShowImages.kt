package com.ryunen344.annotation.perf.db.feature.tivi.entity

data class ShowImages(val images: List<ShowTmdbImage>) {

    val backdrop by lazy(LazyThreadSafetyMode.NONE) {
        findHighestRatedForType(ImageType.BACKDROP)
    }

    val poster by lazy(LazyThreadSafetyMode.NONE) {
        findHighestRatedForType(ImageType.POSTER)
    }

    private fun findHighestRatedForType(type: ImageType): ShowTmdbImage? {
        @Suppress("DEPRECATION") // Can't use maxByOrNull until we're API version 1.4
        return images.filter { it.type == type }
            .maxByOrNull { it.rating + (if (it.isPrimary) 10f else 0f) }
    }
}
