package com.ryunen344.annotation.perf.db.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.ryunen344.annotation.perf.db.converter.LocalDateTimeConverter
import com.ryunen344.annotation.perf.db.converter.OffsetDateTimeConverter
import com.ryunen344.annotation.perf.db.converter.ZonedDateTimeConverter
import com.ryunen344.annotation.perf.db.dao.TimeSetDao
import com.ryunen344.annotation.perf.db.dao.UserDao
import com.ryunen344.annotation.perf.db.dao.dagashi.IssueDao
import com.ryunen344.annotation.perf.db.dao.dagashi.MileStoneDao
import com.ryunen344.annotation.perf.db.entity.TimeSet
import com.ryunen344.annotation.perf.db.entity.User
import com.ryunen344.annotation.perf.db.entity.dagashi.CommentEntity
import com.ryunen344.annotation.perf.db.entity.dagashi.IssueEntity
import com.ryunen344.annotation.perf.db.entity.dagashi.IssueFts
import com.ryunen344.annotation.perf.db.entity.dagashi.LabelEntity
import com.ryunen344.annotation.perf.db.entity.dagashi.MileStoneEntity
import com.ryunen344.annotation.perf.db.entity.dagashi.StashedIssueEntity
import com.ryunen344.annotation.perf.db.entity.dagashi.SummaryIssueEntity
import com.ryunen344.annotation.perf.db.entity.dagashi.relation.IssueLabelCrossRef

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
        User::class
    ],
    version = 1,
    exportSchema = false
)
@TypeConverters(
    value = [
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
}
