package com.example.allcomposeapp.addtask.ui.model

import com.example.allcomposeapp.addtask.data.TaskEntity

data class TaskModel(
    val id: Int = System.currentTimeMillis().hashCode(),
    val task: String,
    var selected: Boolean = false,
)

fun TaskModel.toTaskEntity(): TaskEntity {
    return TaskEntity(
        id = this.id,
        task = this.task,
        selected = this.selected,
    )
}
