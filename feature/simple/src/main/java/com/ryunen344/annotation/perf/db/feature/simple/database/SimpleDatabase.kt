package com.ryunen344.annotation.perf.db.feature.simple.database

import com.ryunen344.annotation.perf.db.feature.simple.dao.SimpleUserDao
import com.ryunen344.annotation.perf.db.feature.simple.dao.TimeSetDao

interface SimpleDatabase {
    val simpleUserDao: SimpleUserDao
    val timeSetDao: TimeSetDao
}
