package com.ryunen344.annotation.perf.db.feature.tivi.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import com.ryunen344.annotation.perf.db.feature.tivi.entity.ShowTmdbImage
import kotlinx.coroutines.flow.Flow

@Dao
abstract class ShowTmdbImagesDao : EntityDao<ShowTmdbImage>() {
    @Query("DELETE FROM show_images WHERE show_id = :showId")
    abstract suspend fun deleteForShowId(showId: Long)

    @Query("SELECT COUNT(*) FROM show_images WHERE show_id = :showId")
    abstract suspend fun imageCountForShowId(showId: Long): Int

    @Query("SELECT * FROM show_images WHERE show_id = :showId")
    abstract fun getImagesForShowId(showId: Long): Flow<List<ShowTmdbImage>>

    @Query("DELETE FROM show_images")
    abstract suspend fun deleteAll()

    @Transaction
    open suspend fun saveImages(showId: Long, images: List<ShowTmdbImage>) {
        deleteForShowId(showId)
        insertOrUpdate(images)
    }

    @Transaction
    open suspend fun saveImagesIfEmpty(showId: Long, images: List<ShowTmdbImage>) {
        if (imageCountForShowId(showId) <= 0) {
            insertAll(images)
        }
    }
}
