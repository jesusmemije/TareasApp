package com.memije.tareasapp.addtasks.domain

import com.memije.tareasapp.addtasks.data.TaskRepository
import com.memije.tareasapp.addtasks.ui.model.TaskModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetTasksUseCase @Inject constructor(private val repository: TaskRepository) {
    operator fun invoke() : Flow<List<TaskModel>> = repository.taskList
}