package com.ryunen344.annotation.perf.db.feature.dagashi.entity.combined

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.ryunen344.annotation.perf.db.feature.dagashi.entity.CommentEntity
import com.ryunen344.annotation.perf.db.feature.dagashi.entity.IssueEntity
import com.ryunen344.annotation.perf.db.feature.dagashi.entity.LabelEntity
import com.ryunen344.annotation.perf.db.feature.dagashi.entity.relation.IssueLabelCrossRef

data class IssueWithLabelAndComment(
    @Embedded
    val issueEntity: IssueEntity,
    @Relation(
        entity = LabelEntity::class,
        parentColumn = "single_unique_id",
        entityColumn = "name",
        associateBy = Junction(
            value = IssueLabelCrossRef::class,
            parentColumn = "single_unique_id",
            entityColumn = "label_name"
        )
    )
    val labels: List<LabelEntity>,
    @Relation(
        parentColumn = "single_unique_id",
        entityColumn = "single_unique_id"
    )
    val comments: List<CommentEntity>,
)
