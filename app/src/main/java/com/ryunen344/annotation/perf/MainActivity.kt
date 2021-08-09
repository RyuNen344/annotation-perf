package com.ryunen344.annotation.perf

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import com.ryunen344.annotation.perf.db.database.PerfDatabase

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d(this::class.java.name, PerfDatabase::class.java.name)

        val db = Room.databaseBuilder(
            applicationContext,
            PerfDatabase::class.java, "database-name"
        ).build()

        db.userDao().getAll()
    }
}
