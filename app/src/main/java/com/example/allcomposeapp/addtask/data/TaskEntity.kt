package com.example.allcomposeapp.addtask.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "task_table")
data class TaskEntity(
    @PrimaryKey
    val id: Int,
    val task: String,
    val selected: Boolean,
)
