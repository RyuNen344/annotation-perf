package com.ryunen344.annotation.perf.db.feature.tivi.database

import com.ryunen344.annotation.perf.db.feature.tivi.dao.EpisodeWatchEntryDao
import com.ryunen344.annotation.perf.db.feature.tivi.dao.EpisodesDao
import com.ryunen344.annotation.perf.db.feature.tivi.dao.FollowedShowsDao
import com.ryunen344.annotation.perf.db.feature.tivi.dao.LastRequestDao
import com.ryunen344.annotation.perf.db.feature.tivi.dao.PopularDao
import com.ryunen344.annotation.perf.db.feature.tivi.dao.RecommendedDao
import com.ryunen344.annotation.perf.db.feature.tivi.dao.RelatedShowsDao
import com.ryunen344.annotation.perf.db.feature.tivi.dao.SeasonsDao
import com.ryunen344.annotation.perf.db.feature.tivi.dao.ShowFtsDao
import com.ryunen344.annotation.perf.db.feature.tivi.dao.ShowTmdbImagesDao
import com.ryunen344.annotation.perf.db.feature.tivi.dao.TiviShowDao
import com.ryunen344.annotation.perf.db.feature.tivi.dao.TrendingDao
import com.ryunen344.annotation.perf.db.feature.tivi.dao.UserDao
import com.ryunen344.annotation.perf.db.feature.tivi.dao.WatchedShowDao

interface TiviDatabase {
    val showDao: TiviShowDao
    val showFtsDao: ShowFtsDao
    val showImagesDao: ShowTmdbImagesDao
    val trendingDao: TrendingDao
    val popularDao: PopularDao
    val userDao: UserDao
    val watchedShowsDao: WatchedShowDao
    val followedShowsDao: FollowedShowsDao
    val seasonsDao: SeasonsDao
    val episodesDao: EpisodesDao
    val relatedShowsDao: RelatedShowsDao
    val episodeWatchesDao: EpisodeWatchEntryDao
    val lastRequestDao: LastRequestDao
    val recommendedShowsDao: RecommendedDao
}
