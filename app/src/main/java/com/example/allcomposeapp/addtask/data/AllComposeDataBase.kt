package com.example.allcomposeapp.addtask.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [TaskEntity::class], version = 1)
abstract class AllComposeDataBase : RoomDatabase() {

    abstract fun taskDao(): TaskDao
}
