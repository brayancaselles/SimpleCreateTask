package com.example.allcomposeapp.addtask.data

import com.example.allcomposeapp.addtask.ui.model.TaskModel
import com.example.allcomposeapp.addtask.ui.model.toTaskEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TaskRepository @Inject constructor(private val taskDao: TaskDao) {

    val tasks: Flow<List<TaskModel>> =
        taskDao.getTask().map { items -> items.map { TaskModel(it.id, it.task, it.selected) } }

    suspend fun insert(taskModel: TaskModel) {
        taskDao.insertTask(
            taskModel.toTaskEntity(),
        )
    }

    suspend fun update(taskModel: TaskModel) {
        taskDao.updateTask(
            taskModel.toTaskEntity(),
        )
    }

    suspend fun delete(taskModel: TaskModel) {
        taskDao.deleteTask(
            taskModel.toTaskEntity(),
        )
    }
}
