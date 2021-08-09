package com.ryunen344.annotation.perf.db.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.ryunen344.annotation.perf.db.converter.CalendarConverter
import com.ryunen344.annotation.perf.db.converter.LocalDateTimeConverter
import com.ryunen344.annotation.perf.db.converter.OffsetDateTimeConverter
import com.ryunen344.annotation.perf.db.converter.ZonedDateTimeConverter
import com.ryunen344.annotation.perf.db.dao.TimeSetDao
import com.ryunen344.annotation.perf.db.dao.UserDao
import com.ryunen344.annotation.perf.db.dao.sunflower.GardenPlantingDao
import com.ryunen344.annotation.perf.db.dao.sunflower.PlantDao
import com.ryunen344.annotation.perf.db.entity.TimeSet
import com.ryunen344.annotation.perf.db.entity.User
import com.ryunen344.annotation.perf.db.entity.sunflower.GardenPlanting
import com.ryunen344.annotation.perf.db.entity.sunflower.Plant
import com.ryunen344.annotation.perf.db.feature.dagashi.dao.IssueDao
import com.ryunen344.annotation.perf.db.feature.dagashi.dao.MileStoneDao
import com.ryunen344.annotation.perf.db.feature.dagashi.entity.CommentEntity
import com.ryunen344.annotation.perf.db.feature.dagashi.entity.IssueEntity
import com.ryunen344.annotation.perf.db.feature.dagashi.entity.IssueFts
import com.ryunen344.annotation.perf.db.feature.dagashi.entity.LabelEntity
import com.ryunen344.annotation.perf.db.feature.dagashi.entity.MileStoneEntity
import com.ryunen344.annotation.perf.db.feature.dagashi.entity.StashedIssueEntity
import com.ryunen344.annotation.perf.db.feature.dagashi.entity.SummaryIssueEntity
import com.ryunen344.annotation.perf.db.feature.dagashi.entity.relation.IssueLabelCrossRef

@Database(
    entities = [
        IssueEntity::class,
        LabelEntity::class,
        CommentEntity::class,
        MileStoneEntity::class,
        SummaryIssueEntity::class,
        IssueLabelCrossRef::class,
        IssueFts::class,
        StashedIssueEntity::class,
        GardenPlanting::class,
        Plant::class,
        TimeSet::class,
        User::class
    ],
    version = 1,
    exportSchema = false
)
@TypeConverters(
    value = [
        CalendarConverter::class,
        LocalDateTimeConverter::class,
        OffsetDateTimeConverter::class,
        ZonedDateTimeConverter::class
    ]
)
abstract class PerfDatabase : RoomDatabase() {
    abstract val issueDao: IssueDao
    abstract val mileStoneDao: MileStoneDao
    abstract val gardenPlantingDao: GardenPlantingDao
    abstract val plantDao: PlantDao
    abstract val timeSetDao: TimeSetDao
    abstract val userDao: UserDao
}
