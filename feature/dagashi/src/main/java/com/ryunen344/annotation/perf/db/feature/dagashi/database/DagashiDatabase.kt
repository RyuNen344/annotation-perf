package com.ryunen344.annotation.perf.db.feature.dagashi.database

import com.ryunen344.annotation.perf.db.feature.dagashi.dao.IssueDao
import com.ryunen344.annotation.perf.db.feature.dagashi.dao.MileStoneDao

interface DagashiDatabase {
    val issueDao: IssueDao
    val mileStoneDao: MileStoneDao
}
