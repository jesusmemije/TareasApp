package com.memije.tareasapp.addtasks.ui

import com.memije.tareasapp.addtasks.ui.model.TaskModel

sealed interface TaskUiState {
    data object Loading : TaskUiState
    data class Error(val throwable: Throwable) : TaskUiState
    data class Success(val taskList: List<TaskModel>) : TaskUiState
}