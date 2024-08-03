package com.memije.tareasapp.addtasks.ui

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.memije.tareasapp.addtasks.ui.model.TaskModel
import javax.inject.Inject

class TasksViewModel @Inject constructor() : ViewModel() {

    private val _showDialog = MutableLiveData<Boolean>()
    val showDialog: LiveData<Boolean> = _showDialog

    private val _taskList = mutableStateListOf<TaskModel>()
    val taskList: List<TaskModel> = _taskList

    fun onDialogClose() {
        _showDialog.value = false
    }

    fun onTaskCreated(task: String) {
        _showDialog.value = false
        _taskList.add(TaskModel(task = task))
    }

    fun onShowDialogClick() {
        _showDialog.value = true
    }

    fun onCheckBoxSelected(taskModel: TaskModel) {
        val index = _taskList.indexOf(taskModel)
        _taskList[index] = _taskList[index].let { task ->
            task.copy(selected = !task.selected)
        }
    }

    fun onItemRemove(taskModel: TaskModel) {
       val task = _taskList.find { it.id == taskModel.id }
        _taskList.remove(task)
    }

}