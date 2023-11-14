package com.example.allcomposeapp.addtask.domain

import com.example.allcomposeapp.addtask.data.TaskRepository
import com.example.allcomposeapp.addtask.ui.model.TaskModel
import javax.inject.Inject

class UpdateTaskUseCase @Inject constructor(private val repository: TaskRepository) {

    suspend operator fun invoke(taskModel: TaskModel) {
        repository.update(taskModel)
    }
}