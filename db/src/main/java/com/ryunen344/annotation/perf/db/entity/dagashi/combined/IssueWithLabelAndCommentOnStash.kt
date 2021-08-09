package com.ryunen344.annotation.perf.db.entity.dagashi.combined

import androidx.room.ColumnInfo
import androidx.room.Embedded

data class IssueWithLabelAndCommentOnStash(
    @Embedded
    val issueWithLabelAndComment: IssueWithLabelAndComment,

    @ColumnInfo(name = "is_stashed")
    val isStashed: Boolean
)
