package com.memije.tareasapp.addtasks.data

import com.memije.tareasapp.addtasks.ui.model.TaskModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TaskRepository @Inject constructor(private val taskDao: TaskDao) {

    val taskList: Flow<List<TaskModel>> = taskDao.getTasks().map { taskEntityList ->
        taskEntityList.map { taskEntity ->
            TaskModel(taskEntity.id, taskEntity.task, taskEntity.selected)
        }
    }

    suspend fun add(taskModel: TaskModel) {
        taskDao.addTask(TaskEntity(taskModel.id, taskModel.task, taskModel.selected))
    }
}