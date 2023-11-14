package com.example.allcomposeapp.addtask.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.allcomposeapp.addtask.domain.DeleteTaskUseCase
import com.example.allcomposeapp.addtask.domain.GetTaskUseCase
import com.example.allcomposeapp.addtask.domain.InsertTaskUseCase
import com.example.allcomposeapp.addtask.domain.UpdateTaskUseCase
import com.example.allcomposeapp.addtask.ui.TaskUiState.Error
import com.example.allcomposeapp.addtask.ui.TaskUiState.Loading
import com.example.allcomposeapp.addtask.ui.TaskUiState.Success
import com.example.allcomposeapp.addtask.ui.model.TaskModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TaskViewModel @Inject constructor(
    private val insertTaskUseCase: InsertTaskUseCase,
    private val updateTaskUseCase: UpdateTaskUseCase,
    private val deleteTaskUseCase: DeleteTaskUseCase,
    getTaskUseCase: GetTaskUseCase,
) :
    ViewModel() {

    private val _showDialog = MutableLiveData<Boolean>()
    val showDialog: LiveData<Boolean> = _showDialog

    val uiState: StateFlow<TaskUiState> = getTaskUseCase().map(::Success)
        .catch { Error(it) }
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), Loading)

    fun onDialogClose() {
        _showDialog.value = false
    }

    fun onTaskCreated(text: String) {
        _showDialog.value = false

        viewModelScope.launch {
            insertTaskUseCase(TaskModel(task = text))
        }
    }

    fun onShowDialogSelected() {
        _showDialog.value = true
    }

    fun onCheckBoxSelected(taskModel: TaskModel) {
        /*val index = _task.indexOf(taskModel)
        _task[index] = _task[index].let { it.copy(selected = !it.selected) }*/
        viewModelScope.launch { updateTaskUseCase(taskModel.copy(selected = !taskModel.selected)) }
    }

    fun onItemRemove(taskModel: TaskModel) {
        /*val task = _task.find { it.id == taskModel.id }
        _task.remove(task)*/
        viewModelScope.launch { deleteTaskUseCase(taskModel) }
    }
}
