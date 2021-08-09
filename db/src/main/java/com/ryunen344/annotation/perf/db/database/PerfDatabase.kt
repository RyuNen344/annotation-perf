package com.ryunen344.annotation.perf.db.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.ryunen344.annotation.perf.db.converter.CalendarConverter
import com.ryunen344.annotation.perf.db.converter.DayOfWeekConverter
import com.ryunen344.annotation.perf.db.converter.InstantConverter
import com.ryunen344.annotation.perf.db.converter.LocalDateTimeConverter
import com.ryunen344.annotation.perf.db.converter.LocalTimeConverter
import com.ryunen344.annotation.perf.db.converter.OffsetDateTimeConverter
import com.ryunen344.annotation.perf.db.converter.ZoneIdConverter
import com.ryunen344.annotation.perf.db.converter.ZonedDateTimeConverter
import com.ryunen344.annotation.perf.db.feature.dagashi.database.DagashiDatabase
import com.ryunen344.annotation.perf.db.feature.dagashi.entity.CommentEntity
import com.ryunen344.annotation.perf.db.feature.dagashi.entity.IssueEntity
import com.ryunen344.annotation.perf.db.feature.dagashi.entity.IssueFts
import com.ryunen344.annotation.perf.db.feature.dagashi.entity.LabelEntity
import com.ryunen344.annotation.perf.db.feature.dagashi.entity.MileStoneEntity
import com.ryunen344.annotation.perf.db.feature.dagashi.entity.StashedIssueEntity
import com.ryunen344.annotation.perf.db.feature.dagashi.entity.SummaryIssueEntity
import com.ryunen344.annotation.perf.db.feature.dagashi.entity.relation.IssueLabelCrossRef
import com.ryunen344.annotation.perf.db.feature.simple.database.SimpleDatabase
import com.ryunen344.annotation.perf.db.feature.simple.entity.SimpleUser
import com.ryunen344.annotation.perf.db.feature.simple.entity.TimeSet
import com.ryunen344.annotation.perf.db.feature.sunflower.database.SunflowerDatabase
import com.ryunen344.annotation.perf.db.feature.sunflower.entity.GardenPlanting
import com.ryunen344.annotation.perf.db.feature.sunflower.entity.Plant
import com.ryunen344.annotation.perf.db.feature.tivi.converter.ImageTypeConverter
import com.ryunen344.annotation.perf.db.feature.tivi.converter.PendingActionConverter
import com.ryunen344.annotation.perf.db.feature.tivi.converter.RequestConverter
import com.ryunen344.annotation.perf.db.feature.tivi.converter.ShowStatusConverter

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
        SimpleUser::class,
        TimeSet::class,
        GardenPlanting::class,
        Plant::class,
    ],
    version = 1,
    exportSchema = false
)
@TypeConverters(
    value = [
        CalendarConverter::class,
        DayOfWeekConverter::class,
        InstantConverter::class,
        LocalDateTimeConverter::class,
        LocalTimeConverter::class,
        OffsetDateTimeConverter::class,
        ZonedDateTimeConverter::class,
        ZoneIdConverter::class,
        ImageTypeConverter::class,
        PendingActionConverter::class,
        RequestConverter::class,
        ShowStatusConverter::class
    ]
)
abstract class PerfDatabase : RoomDatabase(), DagashiDatabase, SimpleDatabase, SunflowerDatabase
