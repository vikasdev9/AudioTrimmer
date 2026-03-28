package com.example.audiotrimmer.data.room.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.audiotrimmer.data.room.dao.CropSegmentDao
import com.example.audiotrimmer.data.room.dao.RecentTableDao
import com.example.audiotrimmer.data.room.entity.CropSegmentTable
import com.example.audiotrimmer.data.room.entity.RecentTable

@Database(entities = [RecentTable::class, CropSegmentTable::class ], version = 1, exportSchema = false)
abstract class AppDataBase: RoomDatabase() {
    abstract fun recentTableDao(): RecentTableDao
    abstract fun recentcropSegmentDao(): CropSegmentDao

}