package com.ryunen344.annotation.perf.db.dao.dagashi

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import com.ryunen344.annotation.perf.db.entity.dagashi.CommentEntity
import com.ryunen344.annotation.perf.db.entity.dagashi.IssueEntity
import com.ryunen344.annotation.perf.db.entity.dagashi.LabelEntity
import com.ryunen344.annotation.perf.db.entity.dagashi.StashedIssueEntity
import com.ryunen344.annotation.perf.db.entity.dagashi.combined.IssueWithLabelAndCommentOnStash
import com.ryunen344.annotation.perf.db.entity.dagashi.relation.IssueLabelCrossRef
import kotlinx.coroutines.flow.Flow

@Dao
abstract class IssueDao : BaseDao<IssueEntity>() {
    @Transaction
    @Query("SELECT *, EXISTS (SELECT * FROM stashed_issue WHERE single_unique_id = issue.single_unique_id) AS is_stashed FROM issue WHERE issue.number = :number ORDER BY id ASC")
    abstract fun select(number: Int): Flow<List<IssueWithLabelAndCommentOnStash>>

    @Transaction
    @Query("SELECT issue.*, 1 AS is_stashed FROM issue JOIN stashed_issue ON issue.single_unique_id = stashed_issue.single_unique_id ORDER BY id ASC")
    abstract fun stashed(): Flow<List<IssueWithLabelAndCommentOnStash>>

    @Transaction
    @Query("SELECT *, EXISTS (SELECT * FROM stashed_issue WHERE single_unique_id = issue.single_unique_id) AS is_stashed FROM issue JOIN IssueFts ON issue.title == IssueFts.title AND issue.body == IssueFts.body WHERE IssueFts MATCH '*'||:keyword||'*'")
    abstract fun search(keyword: String): Flow<List<IssueWithLabelAndCommentOnStash>>
}

@Dao
abstract class LabelDao : BaseDao<LabelEntity>()

@Dao
abstract class IssueLabelCrossRefDao : BaseDao<IssueLabelCrossRef>()

@Dao
abstract class CommentDao : BaseDao<CommentEntity>()

@Dao
abstract class StashedIssueDao : BaseDao<StashedIssueEntity>()
