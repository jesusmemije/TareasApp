package com.memije.tareasapp.addtasks.domain

import com.memije.tareasapp.addtasks.data.TaskRepository
import com.memije.tareasapp.addtasks.ui.model.TaskModel
import javax.inject.Inject

class AddTaskUseCase @Inject constructor(private val repository: TaskRepository) {
    suspend operator fun invoke(taskModel: TaskModel) {
        repository.add(taskModel)
    }
}