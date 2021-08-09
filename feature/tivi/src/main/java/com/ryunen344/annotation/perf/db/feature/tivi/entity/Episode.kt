package com.ryunen344.annotation.perf.db.feature.tivi.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey
import java.time.OffsetDateTime

@Entity(
    tableName = "episodes",
    indices = [
        Index(value = ["trakt_id"], unique = true),
        Index(value = ["season_id"])
    ],
    foreignKeys = [
        ForeignKey(
            entity = Season::class,
            parentColumns = arrayOf("id"),
            childColumns = arrayOf("season_id"),
            onUpdate = ForeignKey.CASCADE,
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class Episode(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    override val id: Long = 0,
    @ColumnInfo(name = "season_id")
    val seasonId: Long,
    @ColumnInfo(name = "trakt_id")
    override val traktId: Int? = null,
    @ColumnInfo(name = "tmdb_id")
    override val tmdbId: Int? = null,
    @ColumnInfo(name = "title")
    val title: String? = null,
    @ColumnInfo(name = "overview")
    val summary: String? = null,
    @ColumnInfo(name = "number")
    val number: Int? = null,
    @ColumnInfo(name = "first_aired")
    val firstAired: OffsetDateTime? = null,
    @ColumnInfo(name = "trakt_rating")
    val traktRating: Float? = null,
    @ColumnInfo(name = "trakt_rating_votes")
    val traktRatingVotes: Int? = null,
    @ColumnInfo(name = "tmdb_backdrop_path")
    val tmdbBackdropPath: String? = null
) : TiviEntity, TraktIdEntity, TmdbIdEntity {
    companion object {
        val EMPTY = Episode(seasonId = 0)
    }

    /**
     * @delegate:Ignore
     * val isAired by lazy { firstAired?.isBefore(OffsetDateTime.now()) ?: false }
     */
    fun isAired(): Boolean {
        return firstAired?.isBefore(OffsetDateTime.now()) ?: false
    }
}
