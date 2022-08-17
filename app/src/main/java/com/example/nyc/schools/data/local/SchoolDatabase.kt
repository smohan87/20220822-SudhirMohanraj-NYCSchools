package com.example.nyc.schools.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [SchoolInformationEntity::class],
    version = 1
)
abstract class SchoolDatabase : RoomDatabase() {
    abstract val dao: SchoolDao
}