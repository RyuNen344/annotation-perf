package com.ryunen344.annotation.perf.db.feature.sunflower.database

import com.ryunen344.annotation.perf.db.feature.sunflower.dao.GardenPlantingDao
import com.ryunen344.annotation.perf.db.feature.sunflower.dao.PlantDao

interface SunflowerDatabase {
    val gardenPlantingDao: GardenPlantingDao
    val plantDao: PlantDao
}
