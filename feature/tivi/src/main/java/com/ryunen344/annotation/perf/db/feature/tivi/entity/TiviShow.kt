package com.ryunen344.annotation.perf.db.feature.tivi.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.Index
import androidx.room.PrimaryKey
import java.time.DayOfWeek
import java.time.LocalTime
import java.time.OffsetDateTime
import java.time.ZoneId

@Entity(
    tableName = "shows",
    indices = [
        Index(value = ["trakt_id"], unique = true),
        Index(value = ["tmdb_id"])
    ]
)
data class TiviShow(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    override val id: Long = 0,
    @ColumnInfo(name = "title")
    val title: String? = null,
    @ColumnInfo(name = "original_title")
    val originalTitle: String? = null,
    @ColumnInfo(name = "trakt_id")
    override val traktId: Int? = null,
    @ColumnInfo(name = "tmdb_id")
    override val tmdbId: Int? = null,
    @ColumnInfo(name = "imdb_id")
    val imdbId: String? = null,
    @ColumnInfo(name = "overview")
    val summary: String? = null,
    @ColumnInfo(name = "homepage")
    val homepage: String? = null,
    @ColumnInfo(name = "trakt_rating")
    val traktRating: Float? = null,
    @ColumnInfo(name = "trakt_votes")
    val traktVotes: Int? = null,
    @ColumnInfo(name = "certification")
    val certification: String? = null,
    @ColumnInfo(name = "first_aired")
    val firstAired: OffsetDateTime? = null,
    @ColumnInfo(name = "country")
    val country: String? = null,
    @ColumnInfo(name = "network")
    val network: String? = null,
    @ColumnInfo(name = "network_logo_path")
    val networkLogoPath: String? = null,
    @ColumnInfo(name = "runtime")
    val runtime: Int? = null,
    @ColumnInfo(name = "genres")
    val genres: String? = null,
    @ColumnInfo(name = "last_trakt_data_update")
    val traktDataUpdate: OffsetDateTime? = null,
    @ColumnInfo(name = "status")
    val status: ShowStatus? = null,
    @ColumnInfo(name = "airs_day")
    val airsDay: DayOfWeek? = null,
    @ColumnInfo(name = "airs_time")
    val airsTime: LocalTime? = null,
    @ColumnInfo(name = "airs_tz")
    val airsTimeZone: ZoneId? = null
) : TiviEntity, TraktIdEntity, TmdbIdEntity {
    @Ignore
    constructor() : this(0)

    /**
     * @delegate:Ignore
     * val genres by lazy(LazyThreadSafetyMode.NONE) {
     *     _genres?.split(",")?.mapNotNull { Genre.fromTraktValue(it.trim()) } ?: emptyList()
     * }
     */
    fun splitGenre(): List<Genre> {
        return genres?.split(",")?.mapNotNull { Genre.fromTraktValue(it.trim()) } ?: emptyList()
    }

    companion object {
        val EMPTY_SHOW = TiviShow()

        fun mergeShows(
            local: TiviShow = TiviShow.EMPTY_SHOW,
            trakt: TiviShow = TiviShow.EMPTY_SHOW,
            tmdb: TiviShow = TiviShow.EMPTY_SHOW
        ) = local.copy(
            title = trakt.title ?: local.title,
            summary = trakt.summary ?: local.summary,
            homepage = trakt.homepage ?: local.homepage,
            certification = trakt.certification ?: local.certification,
            runtime = trakt.runtime ?: local.runtime,
            country = trakt.country ?: local.country,
            firstAired = trakt.firstAired ?: local.firstAired,
            genres = trakt.genres ?: local.genres,
            status = trakt.status ?: local.status,
            airsDay = trakt.airsDay ?: local.airsDay,
            airsTimeZone = trakt.airsTimeZone ?: local.airsTimeZone,
            airsTime = trakt.airsTime ?: local.airsTime,

            // Trakt specific stuff
            traktId = trakt.traktId ?: local.traktId,
            traktRating = trakt.traktRating ?: local.traktRating,
            traktVotes = trakt.traktVotes ?: local.traktVotes,
            traktDataUpdate = trakt.traktDataUpdate ?: local.traktDataUpdate,

            // TMDb specific stuff
            tmdbId = tmdb.tmdbId ?: trakt.tmdbId ?: local.tmdbId,
            network = tmdb.network ?: trakt.network ?: local.network,
            networkLogoPath = tmdb.networkLogoPath ?: local.networkLogoPath
        )
    }
}
