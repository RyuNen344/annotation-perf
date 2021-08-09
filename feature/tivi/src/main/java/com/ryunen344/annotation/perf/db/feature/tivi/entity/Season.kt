package com.ryunen344.annotation.perf.db.feature.tivi.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "seasons",
    indices = [
        Index(value = ["trakt_id"], unique = true),
        Index(value = ["show_id"])
    ],
    foreignKeys = [
        ForeignKey(
            entity = TiviShow::class,
            parentColumns = arrayOf("id"),
            childColumns = arrayOf("show_id"),
            onUpdate = ForeignKey.CASCADE,
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class Season(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id") override val id: Long = 0,
    @ColumnInfo(name = "show_id") val showId: Long,
    @ColumnInfo(name = "trakt_id") override val traktId: Int? = null,
    @ColumnInfo(name = "tmdb_id") override val tmdbId: Int? = null,
    @ColumnInfo(name = "title") val title: String? = null,
    @ColumnInfo(name = "overview") val summary: String? = null,
    @ColumnInfo(name = "number") val number: Int? = null,
    @ColumnInfo(name = "network") val network: String? = null,
    @ColumnInfo(name = "ep_count") val episodeCount: Int? = null,
    @ColumnInfo(name = "ep_aired") val episodesAired: Int? = null,
    @ColumnInfo(name = "trakt_rating") val traktRating: Float? = null,
    @ColumnInfo(name = "trakt_votes") val traktRatingVotes: Int? = null,
    @ColumnInfo(name = "tmdb_poster_path") val tmdbPosterPath: String? = null,
    @ColumnInfo(name = "tmdb_backdrop_path") val tmdbBackdropPath: String? = null,
    @ColumnInfo(name = "ignored") val ignored: Boolean = false
) : TiviEntity, TmdbIdEntity, TraktIdEntity {
    companion object {
        const val NUMBER_SPECIALS = 0
        val EMPTY = Season(showId = 0)
    }
}
