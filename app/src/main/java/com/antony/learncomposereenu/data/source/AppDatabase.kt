package com.antony.learncomposereenu.data.source

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [OrderDetails::class], version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun getSummaryDao() : SummaryDao
}