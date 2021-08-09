package com.ryunen344.annotation.perf.db.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.ryunen344.annotation.perf.db.converter.CalendarConverter
import com.ryunen344.annotation.perf.db.converter.LocalDateTimeConverter
import com.ryunen344.annotation.perf.db.converter.OffsetDateTimeConverter
import com.ryunen344.annotation.perf.db.converter.ZonedDateTimeConverter
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
import com.ryunen344.annotation.perf.db.feature.simple.dao.TimeSetDao
import com.ryunen344.annotation.perf.db.feature.simple.dao.UserDao
import com.ryunen344.annotation.perf.db.feature.simple.entity.TimeSet
import com.ryunen344.annotation.perf.db.feature.simple.entity.User
import com.ryunen344.annotation.perf.db.feature.sunflower.dao.GardenPlantingDao
import com.ryunen344.annotation.perf.db.feature.sunflower.dao.PlantDao
import com.ryunen344.annotation.perf.db.feature.sunflower.entity.GardenPlanting
import com.ryunen344.annotation.perf.db.feature.sunflower.entity.Plant

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
        TimeSet::class,
        User::class,
        GardenPlanting::class,
        Plant::class,
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
    abstract val timeSetDao: TimeSetDao
    abstract val userDao: UserDao
    abstract val gardenPlantingDao: GardenPlantingDao
    abstract val plantDao: PlantDao
}
