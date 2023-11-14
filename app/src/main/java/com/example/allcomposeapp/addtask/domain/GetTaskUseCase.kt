package com.example.allcomposeapp.addtask.domain

import com.example.allcomposeapp.addtask.data.TaskRepository
import com.example.allcomposeapp.addtask.ui.model.TaskModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetTaskUseCase @Inject constructor(private val repository: TaskRepository) {

    operator fun invoke(): Flow<List<TaskModel>> = repository.tasks
}
