package com.memije.tareasapp.addtasks.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [TaskEntity::class], version = 1)
abstract class TareasDatabase : RoomDatabase() {
    abstract fun taskDao(): TaskDao
}